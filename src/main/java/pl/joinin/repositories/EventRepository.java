package pl.joinin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.joinin.models.Event;
import pl.joinin.models.User;

public interface EventRepository  extends CrudRepository<Event, Long> {
	List<Event> findByUserUserId(Long userId);
}
