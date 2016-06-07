package pl.joinin.controllers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CallendarController {
	@RequestMapping(value = "/callendar")
	String callendar(Model model) {
		model.addAttribute("now", LocalDateTime.now());
		return "callendar";
	}
}
