package pl.joinin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class JoinInApplication {

	@RequestMapping(value = "/",  produces = "text/plain;charset=UTF-8")
    @ResponseBody
    String home() {
      return "Hello World!";
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(JoinInApplication.class, args);
	}
}
