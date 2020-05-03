package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BadFortuneService implements FortuneService {
	
	@Value("${foo.fortunes}")
	private String fortunes;

	@Override
	public String getFortune() {
		String[] fortunesArr = fortunes.split(",");
		
		Random random = new Random();
		String fortune = fortunesArr[random.nextInt(fortunesArr.length)];
		return fortune;
	}

}
