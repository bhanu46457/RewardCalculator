package com.rp.service;

import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rp.model.TransactionData;

@Service
public class RewardsService {

	public Map<String, Integer> getTransaction(List<TransactionData> transactions) {

		Map<String, Integer> response = new HashMap<String, Integer>();
		
		if(transactions == null) {
			return response;
		}

		Map<String, List<TransactionData>> transactionsByMonth = transactions.stream()
				.collect(Collectors.groupingBy(t -> getMonthForInt(t.getDate().getMonth())));
		int totalRewards = 0;
		for (String month : transactionsByMonth.keySet()) {
			List<TransactionData> monthTransactions = transactionsByMonth.get(month);
			int rewardsPerMonth = 0;
			for (TransactionData tr : monthTransactions) {
				int rewards = getRewards(tr.getAmount());
				rewardsPerMonth = rewardsPerMonth + rewards;
			}
			response.put(month, rewardsPerMonth);
			totalRewards = totalRewards + rewardsPerMonth;
		}
		response.put("TotalRewards", totalRewards);

		return response;
	}

	private int getRewards(int amount) {
		int rewards = 0;
		if (amount > 50 && amount <= 100) {
			rewards = amount - 50;
		} else if (amount > 100) {
			rewards = 50 + ((amount - 100) * 2);
		}
		return rewards;
	}

	private String getMonthForInt(int num) {
		String month = "wrong";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		if (num >= 0 && num <= 11) {
			month = months[num];
		}
		return month;
	}

}
