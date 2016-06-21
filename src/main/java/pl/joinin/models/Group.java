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
@Table(name = "groups")
public class Group implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 // COLUMNS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "companyId")
    private Company company;
	
	@Column(nullable = false)
    private String groupName;

    protected Group() {}

    public Group(Company company, String groupName) {
        this.company = company;
        this.groupName = groupName;
    }
    
     // GETTERS
    public Company getCompany() {
        return this.company;
    }

    public String getGroupName() {
        return this.groupName;
    }
    
     // SETTERS
    public void setCompany(Company company) {
        this.company = company;
    }

    public void setGroupName(String name) {
        this.groupName = name;
    }    

}

