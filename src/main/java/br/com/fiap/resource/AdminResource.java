package br.com.fiap.resource;

import br.com.fiap.bo.AdminBO;
import br.com.fiap.to.AdminTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/smartenergy/admin")
public class AdminResource {

    private AdminBO adminBO = new AdminBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<AdminTO> resultado = adminBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok(); //codigo 200 - OK
        } else {
            response = Response.status(404); // codigo 404 - NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{cpf_admin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("cpf_admin") String cpf_admin){
        AdminTO resultado = adminBO.findByCodigo(cpf_admin);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok(); // codigo 200 - ok
        } else {
            response = Response.status(404); // codigo 404 - not found
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid AdminTO admin){
        AdminTO resultado = adminBO.save(admin);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null); // codigo 201 - create
        } else {
            response = Response.status(400); // codigo 401 - bad request
        }
        response.entity(resultado);
        return response.build();
    }

    @PUT
    @Path("{/cpf_admin}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid AdminTO admin, @PathParam("cpf_admin") String cpf_admin){
        admin.setCpf_admin(cpf_admin);
        AdminTO resultado = adminBO.update(admin);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null); // codigo 201 - create
        } else {
            response = Response.status(400); // codigo 401 - bad request
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("{/cpf_admin}")
    public Response delete(@PathParam("cpf_admin") String cpf_admin){
        Response.ResponseBuilder response = null;
        if (adminBO.delete(cpf_admin)){
            response = Response.status(204); // codigo 204 - no content
        } else {
            response = Response.status(404); // codigo 404 - not found
        }
        return response.build();
    }

}
