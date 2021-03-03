package org.bitingbit.model.authorization;

import org.bitingbit.model.authentication.UserDetail;

import javax.persistence.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity(name="UserRole")
@Table(name="userrole")
@NamedQuery(name = "UserRole.findAll", query = "SELECT c FROM UserRole c ORDER BY c.id")
public class UserRole {

    public enum Role {
        ADMIN,
        OWNER,
        USER,
    }

    public UserRole() {};
    public UserRole(Role role) {
        this.role = role;
    }

    @Id
    @SequenceGenerator(name = "roleSeq", sequenceName = "role_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "roleSeq")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Role role;

    @OneToMany( targetEntity = UserDetail.class, cascade = CascadeType.MERGE)
    private Set<UserDetail> users = new HashSet<UserDetail>();




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
