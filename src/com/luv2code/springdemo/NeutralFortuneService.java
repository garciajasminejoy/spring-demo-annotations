package com.luv2code.springdemo;

public class NeutralFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "This is a neutral fortune statement";
	}

}
