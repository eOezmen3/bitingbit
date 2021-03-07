package org.bitingbit.controllers;

import org.bitingbit.model.authentication.UserDetail;
import org.bitingbit.model.authorization.UserRole;

import org.bitingbit.model.authorization.UserRole.Role;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserDetailController {

    private final long singleUsersId = 1;

    @Inject
    EntityManager entityManager;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public UserDetail getUserDetail(@PathParam("id") String id) {
        UserDetail userDetail = entityManager.find(UserDetail.class, Long.parseLong(id));
       
        if (userDetail == null) {
          userDetail = new UserDetail();
        }
        entityManager.find(UserDetail.class, Long.parseLong(id));

        return userDetail;
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON})
    public UserDetail updateUserDetail(@PathParam("id") String id, UserDetail newUserdetail) {
        UserDetail userDetail = null;
        try {
            userDetail = entityManager.find(UserDetail.class, singleUsersId);
            if(userDetail == null ) userDetail = new UserDetail();
            userDetail.setFirstName(newUserdetail.getFirstName());
            userDetail.setSurname(newUserdetail.getSurname());
            userDetail.setEmailAddress(newUserdetail.getEmailAddress());
            userDetail.setUserRole(newUserdetail.getUserRole());
            entityManager.merge(userDetail);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return userDetail;
    }

}
