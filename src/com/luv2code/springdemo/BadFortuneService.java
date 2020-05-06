package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class BadFortuneService implements FortuneService {
	
	private String filePath = "C:/xampp/htdocs/spring-demo-annotations/src/Fortunes.txt";
	private ArrayList<String> fortunes;
	
	public BadFortuneService() {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(filePath));
			this.fortunes = new ArrayList<String>();
			
			String line = "";
			while ((line = br.readLine()) != null && !line.isEmpty()) {
				this.fortunes.add(line);
			}
		} catch(Exception e) {
			System.err.format("IOException: %s%n", e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public String getFortune() {
		Random random = new Random();
		String fortune = this.fortunes.get(random.nextInt(this.fortunes.size()));
		return fortune;
	}
	
	@PostConstruct
	public void fortuneServiceCleanup() {
		try {
			BufferedReader br2 = new BufferedReader(new FileReader(this.filePath));
			ArrayList<String> badFortunes = new ArrayList<String>();
			
			String theBadFortune = "";
			while ((theBadFortune = br2.readLine()) != null) {
				badFortunes.add(theBadFortune);
			}
			
			System.out.println("The bad fortunes: " + badFortunes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
