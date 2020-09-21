package com.rp.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rp.model.TransactionData;
import com.rp.service.RewardsService;

@RestController
public class RewardsController {

	@Autowired
	private RewardsService service;

	@RequestMapping("/calculateRewards")
	public Map<String, Integer> getRewards(@RequestBody List<TransactionData> transactions) {
		Map<String, Integer> response = service.getTransaction(transactions);
		return response;
	}

}
