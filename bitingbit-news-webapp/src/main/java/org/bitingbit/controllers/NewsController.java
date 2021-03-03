package org.bitingbit.controllers;

import org.bitingbit.model.News;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/")
public class NewsController {

    @GET
    @Path("news-src1")
    @Produces({MediaType.APPLICATION_JSON})
    public News[] getNewsFromSource1() {
        News[] res = null;
        try {
            News news2 = new News();
            news2.setId(new Long(1));
            news2.setHeadline("Johnny Depp in trouble");
            news2.setContent("Johnny Depp lost his roles after conviction of beating Amper Heart");

            News news1 = new News();
            news1.setId(new Long(2));
            news1.setHeadline("Elon Musk's has a name for his new born sun");
            news1.setContent("Elon Musk named his son X Æ A-12");

            res = new News[]{news1, news2};
        }catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
        return res;
    }

    @GET
    @Path("news-src2")
    @Produces({MediaType.APPLICATION_JSON})
    public News[] getNewsFromSrc2() {
        News[] res = null;
        try {
            News news2 = new News();
            news2.setId(new Long(1));
            news2.setHeadline("Covid effects on the finance");
            news2.setContent("Experts says that the effect of the covid");

            News news1 = new News();
            news1.setId(new Long(2));
            news1.setHeadline("Covid still big issue in our lives");
            news1.setContent("Despite lock down for almost a year, covid sill in our lives");

            res = new News[]{news1, news2};
        }catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
        return res;
    }

}