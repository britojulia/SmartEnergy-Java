package br.com.fiap.resource;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.bo.EletroBO;
import br.com.fiap.to.ClienteTO;
import br.com.fiap.to.EletroTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/smartenergy/eletro")

public class EletroResource {
    private EletroBO eletroBO = new EletroBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<EletroTO> resultado = eletroBO.findAll();
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
    @Path("/{id_eletro}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("id_eletro") Long id_eletro){
        EletroTO resultado = eletroBO.findByCodigo(id_eletro);
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
    public Response save(@Valid EletroTO eletro){
        EletroTO resultado = eletroBO.save(eletro);
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
    @Path("{/id_eletro}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid EletroTO eletro, @PathParam("id_eletro") Long id_eletro){
        eletro.setId_eletro(id_eletro);
        EletroTO resultado = eletroBO.update(eletro);
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
    @Path("{/id_eletro}")
    public Response delete(@PathParam("id_eletro") Long id_eletro){
        Response.ResponseBuilder response = null;
        if (eletroBO.delete(id_eletro)){
            response = Response.status(204); // codigo 204 - no content
        } else {
            response = Response.status(404); // codigo 404 - not found
        }
        return response.build();
    }
}
