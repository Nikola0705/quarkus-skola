
package resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Ucenik;
import repository.UcenikRepository;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

@Path("/ucenik")
public class UcenikResource {

    @Inject
    UcenikRepository ucenikRepository;

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response uploadFile(@QueryParam("id") Long id, @MultipartForm FileForm form) throws IOException {
        Ucenik ucenik = ucenikRepository.findById(id);
        if (ucenik == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        File uploads = new File("uploads");
        if (!uploads.exists()) uploads.mkdirs();

        String filePath = "uploads/" + form.fileName;
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(form.data);
        }

        ucenik.setPutanjaDoFajla(filePath);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getUcenikFile(@PathParam("id") Long id) throws IOException {
        Ucenik ucenik = ucenikRepository.findById(id);
        if (ucenik == null || ucenik.getPutanjaDoFajla() == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        File file = new File(ucenik.getPutanjaDoFajla());
        if (!file.exists()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(Files.readAllBytes(file.toPath()), MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename="" + file.getName() + """)
                .build();
    }
}
