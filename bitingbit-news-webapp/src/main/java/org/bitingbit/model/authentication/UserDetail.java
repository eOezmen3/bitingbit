package org.bitingbit.model.authentication;

import org.bitingbit.model.authorization.UserRole;
import javax.persistence.*;

@Entity(name="UserDetail")
@Table(name="userdetail")
public class UserDetail {

    private Long id;
    private String firstName;
    private String surname;
    private String emailAddress;
    private UserRole userRole;

    @Id
    @SequenceGenerator(name = "userDetailsSeq", sequenceName = "userDetails_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "userDetailsSeq")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserRole.class)
    public UserRole getUserRole() { return this.userRole; }
    public void setUserRole(UserRole userRole) { this.userRole = userRole; }
}
