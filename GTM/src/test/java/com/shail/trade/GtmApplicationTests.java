package com.shail.trade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shail.trade.bo.Tradebo;
import com.shail.trade.exception.InvalidTradeException;
import com.shail.trade.service.TradeService;

@SpringBootTest
class GtmApplicationTests {

	@Autowired
	TradeService tradeService;

	@Test
	void contextLoads() {

	}

	Tradebo t1 = new Tradebo("T1", 1, "CP-1", "B1", LocalDate.of(2021, 9, 12), 'N');
	Tradebo t2 = new Tradebo("T2", 2, "CP-2", "B1", LocalDate.of(2021, 9, 14), 'N');
	Tradebo t3 = new Tradebo("T2", 1, "CP-1", "B1", LocalDate.of(2021, 9, 14), 'N');
	Tradebo t4 = new Tradebo("T1", 2, "CP-3", "B2", LocalDate.of(2021, 9, 14), 'N');
	Tradebo t5 = new Tradebo("T1", 3, "CP-3", "B2", LocalDate.of(2021, 9, 14), 'N');

	@Test
	void testInvalidMaturityDateTrade() throws Exception {
		tradeService.addTrade(t1);
	}

	@Test
	void testAddValidTrade() {

		List<Tradebo> tradeList = new ArrayList<Tradebo>();
		List<Tradebo> invalidtradeList = new ArrayList<Tradebo>();
		tradeList.add(t1);
		tradeList.add(t2);
		tradeList.add(t3);
		tradeList.add(t4);
		tradeList.add(t5);
		for (Tradebo trade : tradeList) {
			try {
				tradeService.addTrade(trade);
			} catch (InvalidTradeException e) {
				invalidtradeList.add(trade);
			}
		}
		tradeService.printAllTrades();
	}

	@Test
	void testUpdateValidTrade() {

		List<Tradebo> tradeList = new ArrayList<Tradebo>();
		List<Tradebo> invalidtradeList = new ArrayList<Tradebo>();
		tradeList.add(t1);
		tradeList.add(t2);
		tradeList.add(t3);
		tradeList.add(t4);
		tradeList.add(t5);
		for (Tradebo trade : tradeList) {
			try {
				tradeService.addTrade(trade);
			} catch (InvalidTradeException e) {
				invalidtradeList.add(trade);
			}
		}
		tradeService.printAllTrades();
		tradeService.updateExpiryFlagOfTrade();
		tradeService.printAllTrades();
	}

}
