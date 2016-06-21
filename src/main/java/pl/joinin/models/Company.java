package pl.joinin.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 // COLUMNS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
	
	@Column(nullable = false)
    private String companyName;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "adminId", referencedColumnName = "userId")
    private User admin;

    protected Company() {}

    public Company(String companyName, User admin) {
        this.companyName = companyName;
        this.admin = admin;
    }
    
     // GETTERS
    public String getCompanyName() {
        return this.companyName;
    }

    public User getAdmin() {
        return this.admin;
    }
    
     // SETTERS
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }    

}
