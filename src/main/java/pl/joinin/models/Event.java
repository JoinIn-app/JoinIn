package pl.joinin.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 // COLUMNS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
	
	@Column(nullable = false)
    private String title;
	
	@Column(nullable = false)
    private Date startDate;
	
	@Column
    private Date endDate;
	
	@Column
    private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "groupId")
	private Group group;

    protected Event() {}

    public Event(String title, Date startDate, Date endDate, String description, User user, Group group) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.user = user;
        this.group = group;
    }
    
     // GETTERS
    public Long getEventId() {
        return this.eventId;
    }
    
    public String getTitle() {
        return this.title;
    }

    public Date getStartDate() {
        return this.startDate;
    }
    
    public Date getEndDate() {
        return this.endDate;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public Group getGroup() {
        return this.group;
    }
    
     // SETTERS
    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }
    
    public void setEndDate(Date date) {
        this.endDate = date;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public void setGroup(Group group) {
        this.group = group;
    }    

}
