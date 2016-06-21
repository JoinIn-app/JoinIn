package pl.joinin.models;

import java.io.Serializable;

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
@Table(name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 // COLUMNS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
	
	@Column(nullable = false)
    private String login;
	
	@Column(nullable = false)
    private String password;
	
	@Column(nullable = false)
    private String firstName;
	
	@Column(nullable = false)
    private String lastName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "companyId")
    private Company company;

    protected User() {}

    public User(String login, String password, String firstName, String lastName, Company company) {
    	this.login = login;
        this.password = password;
    	this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }
    
     // GETTERS
    public Long getUserId() {
        return this.userId;
    }
    
    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public Company getCompany() {
        return this.company;
    }
    
     // SETTERS
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }    

}
