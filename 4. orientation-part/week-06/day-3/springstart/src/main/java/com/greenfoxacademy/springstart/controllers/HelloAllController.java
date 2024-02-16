package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Random;

@Controller
public class HelloAllController {

	@RequestMapping("/web/greetingAll")
	public String greetingAll(
		Model model
	) {

		String[] greetings = {
			"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo",
			"Hello", "Saluton", "Hei", "Bonjour", "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste",
			"Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit", "Salve", "Ciao",
			"Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte",
			"Hola", "Jambo", "Hujambo", "Hej", "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae",
			"Sholem Aleychem", "Sawubona"
		};

		String[] colors = {
			"red", "green", "blue", "yellow", "black", "gray", "orange", "purple", "pink"
		};

		Random random = new Random();
		int randomGreetings = random.nextInt(greetings.length);
		int randomColor = random.nextInt(colors.length);

		model.addAttribute("greeting", greetings[randomGreetings]);
		model.addAttribute("color", colors[randomColor]);

		return "helloAll";
	}
}
