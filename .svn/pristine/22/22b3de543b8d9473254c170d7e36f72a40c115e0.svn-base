/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.shinsensei.deliverablesHub.entities;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import static javax.persistence.GenerationType.IDENTITY;
/**
 *  Mapping for System User
 * @author Francesco Bux
 */
@Entity
@Table(name = "system_users", catalog = "deliverables_hub", uniqueConstraints = @UniqueConstraint(columnNames="email") )
@org.hibernate.annotations.Entity(dynamicUpdate =true)  
public class SystemUser implements java.io.Serializable{
    
    private Integer userId;
    private String password;
    private String email;
    private Date registrationDate;
    private String type;
    private Person person;
     
    public static final String USER_ID     = "userID";
    public static final String EMAIL       = "email";
    public static final String PASSWORD    = "password";
    public static final String REGISTRATION_DATE = "registration_date";
    public static final String TYPE        = "type";
    
    public SystemUser(){}
    
    public SystemUser(String password, String email, Date registrationDate, String type) {
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
        this.type = type;
    }
   
    public SystemUser(String password, String email, Date registrationDate, String type, Person person) {
       this.password = password;
       this.email = email;
       this.registrationDate = registrationDate;
       this.type = type;
       this.person = person;
    }
    
    /* =========== Fields ============= */
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="userID", unique=true, nullable=false)
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="email", unique=true, nullable=false, length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="registrationDate", nullable=false, length=19)
    public Date getRegistrationDate() {
        return this.registrationDate;
    }
    
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    @Column(name="type", nullable=false, length=9)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "systemUser", cascade = CascadeType.ALL)
    public Person getPerson() {
            return this.person;
    }

    public void setPerson(Person person) {
            this.person = person;
    }
}
