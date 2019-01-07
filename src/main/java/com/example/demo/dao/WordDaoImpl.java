package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Word;

public abstract class WordDaoImpl implements WordDao {
	
	@Autowired
	LoadBalancerClient loadBalancer;
	
	public abstract String getPartOfSpeech();

	@Override
	public Word getWord() {
		ServiceInstance instance = loadBalancer.choose(getPartOfSpeech());
		Word word = (new RestTemplate()).getForObject(instance.getUri(), Word.class);
		return word;
	}

}
