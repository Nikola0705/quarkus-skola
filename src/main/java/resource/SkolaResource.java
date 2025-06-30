package resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Skola;
import repository.SkolaRepository;

import java.util.List;

@Path("/skole")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SkolaResource {

    @Inject
    SkolaRepository skolaRepository;

    @POST
    public void createSkola(Skola skola) {
        skolaRepository.createSkola(skola);
    }

    @GET
    public List<Skola> getAllSkole() {
        return skolaRepository.getAllSkole();
    }
}