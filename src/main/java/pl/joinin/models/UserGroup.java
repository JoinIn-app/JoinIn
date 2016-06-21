package pl.joinin.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_groups")
public class UserGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 // COLUMNS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relationId;	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "userId")
    private User user;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "groupId")
    private Group group;

    protected UserGroup() {}

    public UserGroup(User user, Group group) {
    	this.user = user;
        this.group = group;
    }
    
     // GETTERS
    public User getUser() {
        return this.user;
    }

    public Group getGroup() {
        return this.group;
    }
      
    
     // SETTERS
    public void setUser(User user) {
        this.user = user;
    }

    public void setGroup(Group group) {
        this.group = group;
    }     

}
