package resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Ucitelj;
import repository.UciteljRepository;

@Path("/ucitelji")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UciteljResource {

    @Inject
    UciteljRepository uciteljRepository;

    @POST
    @Transactional
    public void createUcitelj(Ucitelj ucitelj) {
        uciteljRepository.createUcitelj(ucitelj);
    }
}