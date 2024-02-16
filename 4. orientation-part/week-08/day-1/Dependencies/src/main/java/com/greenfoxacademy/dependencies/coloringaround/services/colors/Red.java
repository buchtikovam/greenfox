package com.greenfoxacademy.dependencies.coloringaround.services.colors;

import com.greenfoxacademy.dependencies.coloringaround.contracts.MyColor;
import org.springframework.stereotype.Service;

@Service
public class Red implements MyColor {
	@Override
	public void printColor() {
		System.out.println("It is red in color...");
	}
}
