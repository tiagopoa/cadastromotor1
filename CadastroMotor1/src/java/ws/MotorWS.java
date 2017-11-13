/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entidade.Motor;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author 630610194
 */
@Path("motores")
public class MotorWS {

    @Context
    private UriInfo context;
    static List<Motor> listaMotores = new ArrayList<>();

    /**
     * Creates a new instance of MotorWS
     */
    public MotorWS() {
    }

    /**
     * Retrieves representation of an instance of ws.MotorWS
     * @return an instance of entidade.Motor
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Motor> getMotor() {
        listaMotores.add(new Motor(1,"Motor1", "XXX", "Veicular"));
        listaMotores.add(new Motor(2,"Motor2", "XXX", "Veicular"));
        listaMotores.add(new Motor(3,"Motor3", "XXX", "Veicular"));
        return listaMotores;
        //return null;
    }

    /**
     * PUT method for updating or creating an instance of MotorWS
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserirMotor(Motor motor) {
        System.out.println("Dado inserido com sucesso!!!");
        listaMotores.add(motor);
    }
}
