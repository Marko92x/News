/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.cmsrest.cms.rest;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import rs.htec.cmsrest.cms.news.Controller;
import rs.htec.cmsrest.cms.news.DBBroker;
import rs.htec.cmsrest.cms.news.News;

/**
 *
 * @author marko
 */
@Path("/news")
public class RestEndpoint {

    
    // this too
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ispis")
    public Response helloWorld() {
        return Response.ok().entity(Controller.getInstance().readNews()).build();
    }

    //Change, this is shit
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insert() {
        News a = new News();
        Controller.getInstance().insertNews(a);

        return Response.ok("Uspesno ubacena vest").build();  
    }

}
