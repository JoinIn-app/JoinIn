package pl.joinin.controllers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value = "/")
	String index(Model model) {
		model.addAttribute("now", LocalDateTime.now());
		return "index";
	}
}
