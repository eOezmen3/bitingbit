package org.bitingbit.controllers;

import io.vertx.core.json.Json;
import org.bitingbit.model.authorization.UserRole;
import org.bitingbit.model.authentication.UserDetail;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/")
public class UserRoleController {


    @Inject
    EntityManager entityManager;

    @GET
    @Path("roles")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON})
    public List<UserRole> getUserRoles() {
        List<UserRole> roles =  entityManager.createNamedQuery("UserRole.findAll", UserRole.class).getResultList();
        System.out.println(roles.size());
        if(roles.size() == 0) {
            UserRole role1 = new UserRole(UserRole.Role.ADMIN);
            entityManager.persist(role1);

            UserRole  role2 = new UserRole(UserRole.Role.OWNER);
            entityManager.persist(role2);

            UserRole role3 = new UserRole(UserRole.Role.USER);
            entityManager.persist(role3);

            roles =  entityManager.createNamedQuery("UserRole.findAll", UserRole.class).getResultList();
        }
        return roles;
    }
}
