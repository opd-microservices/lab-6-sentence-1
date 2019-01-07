package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SentenceService;



@RestController
public class Lab6Sentence1Controller {
	
	@Autowired SentenceService sentenceService;
	
	@GetMapping("/sentence")
	  public @ResponseBody String getSentences() {
		return 
				"<h3>Some Sentences</h3><br/>" +	  
				sentenceService.buildSentence() + "<br/><br/>" +
				sentenceService.buildSentence() + "<br/><br/>" +
				sentenceService.buildSentence() + "<br/><br/>" +
				sentenceService.buildSentence() + "<br/><br/>" +
				sentenceService.buildSentence() + "<br/><br/>"
				;
	  }
}
