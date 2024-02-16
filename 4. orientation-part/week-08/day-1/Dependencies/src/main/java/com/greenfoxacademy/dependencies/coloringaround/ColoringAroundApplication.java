package com.greenfoxacademy.dependencies.coloringaround;

import com.greenfoxacademy.dependencies.coloringaround.contracts.MyColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ColoringAroundApplication {
	@Autowired
	public ColoringAroundApplication(MyColor myColor) {
		myColor.printColor();
	}

	public static void main(String... args) {
		SpringApplication.run(com.greenfoxacademy.dependencies.coloringaround.ColoringAroundApplication.class, args);
	}
}
