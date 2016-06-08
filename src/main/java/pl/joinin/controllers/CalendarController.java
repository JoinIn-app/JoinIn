package pl.joinin.controllers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalendarController {	
	
	@RequestMapping(value = "/calendar")
	String callendar(Model model) {
		model.addAttribute("now", LocalDateTime.now());
		return "calendar";
	}
}
