package pl.joinin.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.joinin.repositories.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/")
	String index(Model model) {
		model.addAttribute("now", LocalDateTime.now());
		model.addAttribute("testUser", userRepository.findOne(1L));
		return "index";
	}
}
