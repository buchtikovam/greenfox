package com.greenfoxacademy.dependencies.coloringaround.services.colors;

import com.greenfoxacademy.dependencies.coloringaround.contracts.MyColor;
import org.springframework.stereotype.Service;

public class Blue implements MyColor {
	@Override
	public void printColor() {
		System.out.println("It is blue in color...");
	}
}
