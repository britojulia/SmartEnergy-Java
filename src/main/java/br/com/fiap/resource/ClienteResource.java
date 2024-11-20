package br.com.fiap.resource;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.to.ClienteTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/smartenergy/cliente")
public class ClienteResource {

    private ClienteBO clienteBO = new ClienteBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ClienteTO> resultado = clienteBO.findAll();
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
    @Path("/{cpf_cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("cpf_cliente") String cpf_cliente){
        ClienteTO resultado = clienteBO.findByCodigo(cpf_cliente);
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
    public Response save(@Valid ClienteTO cliente){
        ClienteTO resultado = clienteBO.save(cliente);
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
    @Path("{/cpf_cliente}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ClienteTO cliente, @PathParam("cpf_cliente") String cpf_cliente){
        cliente.setCpf_cliente(cpf_cliente);
        ClienteTO resultado = clienteBO.update(cliente);
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
    @Path("{/cpf_cliente}")
    public Response delete(@PathParam("cpf_cliente") String cpf_cliente){
        Response.ResponseBuilder response = null;
        if (clienteBO.delete(cpf_cliente)){
            response = Response.status(204); // codigo 204 - no content
        } else {
            response = Response.status(404); // codigo 404 - not found
        }
        return response.build();
    }
}
