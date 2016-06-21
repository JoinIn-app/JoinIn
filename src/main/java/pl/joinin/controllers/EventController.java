package pl.joinin.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import pl.joinin.models.Event;
import pl.joinin.repositories.EventRepository;

@Controller
public class EventController {
	
	@Autowired
	EventRepository eventRepository;
	
	@RequestMapping(value = "/event")
	String event(Model model) {
		model.addAttribute("now", LocalDateTime.now());
		//model.addAttribute("testUser", userRepository.findOne(1L));
		return "event";
	}
	
	@RequestMapping(value = "/event/getEvent", method = RequestMethod.GET)
    public
    @ResponseBody
    String getEvent(HttpServletResponse response) {
		List<EventObject> objList = new ArrayList<EventObject>();	

		// Prepare list of events
		List<Event> events = eventRepository.findByUserUserId(1L);     // static so far!!!!!!!!!!!
		for (Event event : events) {
			Long id = event.getEventId();
			String title = event.getTitle();
			String description = event.getDescription();
			if (description == null) {
				description = "";
			}
			String startDate = event.getStartDate().toString();
			String endDate = (event.getEndDate() == null) ? "" : event.getEndDate().toString();
			
			objList.add(new EventObject(id, title, description, startDate, endDate));
		}

        // Convert to JSON string.
        String json = new Gson().toJson(objList);        

        // Write JSON string.
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        return json;
    }
	
	private static class EventObject {
	    private Long id;
	    private String title;
	    private String start;
	    private String end;
	    private String description;

	    public EventObject(Long id, String title, String description, String start, String end) {
	    	this.id = id;
	        this.title = title;
	        this.description = description;
	        this.start = start;
	        this.end = end;	    	        
	    }
	}
}
