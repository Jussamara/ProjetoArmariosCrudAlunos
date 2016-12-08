/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Armario;
import rn.ArmarioRN;

/**
 * REST Web Service
 *
 * @author juliano
 */
@Path("armarios")
public class ArmarioWS {
    
    @EJB
    private ArmarioRN armarioRN;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ArmarioWS
     */
    public ArmarioWS() {
    }

    /**
     * Retrieves representation of an instance of ws.ArmarioWS
     * @return an instance of model.Armario
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Armario> getArmarios() {
        return armarioRN.listar();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Armario getArmario(@PathParam("id") long id) {
        return armarioRN.buscar(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void adicionarArmario(Armario a, @Context final HttpServletResponse response) {
        armarioRN.salvar(a);
        //Alterar o codigo para 201 (Created)
        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException e) {
            //Erro 500
            throw new InternalServerErrorException();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public void alterarArmario(@PathParam("id") long id, Armario armario) {
        Armario a =armarioRN.buscar(id);
        a.setNumero(armario.getNumero());
        a.setLocalizacao(armario.getLocalizacao());
        armarioRN.atualizar(a);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Armario removerArmario(@PathParam("id") long id) {
        Armario a =armarioRN.buscar(id);
        armarioRN.remover(a);
        return a;
    }
}
