package com.shail.trade.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shail.trade.bo.Tradebo;
import com.shail.trade.exception.InvalidTradeException;

@Service
public class TradeService {
	HashMap<String, List<Tradebo>> tradeMap = new HashMap<String, List<Tradebo>>();
	

	private static void checkVersion(Tradebo t, int version) throws InvalidTradeException {
		if (t.getVersion() < version) {
			throw new InvalidTradeException(t.getId(),   version+ " is Lower version" );
		}
	}

	private static boolean checkMaturityDate(LocalDate maturityDate) {
		return (LocalDate.now().compareTo(maturityDate) <= 0);
	}

/*	public List<Tradebo> getTrade(String tId) throws InvalidTradeException {
		if (tradeMap.containsKey(tId))
			return tradeMap.get(tId);
		throw new InvalidTradeException("Trade with " + tId + " not Found", "");
	}*/

	public  void printAllTrades() {
		tradeMap.forEach((K, V) -> System.out.print(V + "  " + V));
	}

	public void addTrade(Tradebo trade) throws InvalidTradeException {
		
		String	tradeKey=trade.getId()+trade.getVersion();
		List<Tradebo> tList=  tradeMap.get(trade.getId());
		if (null==tList||tList.isEmpty()) {
			if (checkMaturityDate(trade.getMaturityDate())) {
				tradeMap.put(trade.getId(), Arrays.asList(trade));
				System.out.println(tradeKey + " is added to the Store");
			} else {
				throw new InvalidTradeException(tradeKey, " Maturity date is lower than todate ");
			}
			
		} else {
			tList.stream().forEach(t -> checkVersion(trade, t.getVersion()));
			tList=	new ArrayList<Tradebo>(tList);
			if (checkMaturityDate(trade.getMaturityDate())) {
				tList.add(trade);
				tradeMap.replace(trade.getId(), tList);
				System.out.println(trade.getId() + " is added to the Store");
			} else {
				throw new InvalidTradeException(trade.getId(), " Blank field ");
			}
		}
	}

	

	public void updateExpiryFlagOfTrade() {
		LocalDate currentDate = LocalDate.now();

		for (String strKey : tradeMap.keySet()) {
			tradeMap.get(strKey).stream().forEach( trade ->
			{ 
				System.out.println(currentDate.compareTo(trade.getMaturityDate()) );
				if( currentDate.compareTo(trade.getMaturityDate()) < 0) {
				
			trade.setExpired('Y');
			}
			} );
			  // tradeList=tradeList.stream().m for()
		}	  

	}
}
