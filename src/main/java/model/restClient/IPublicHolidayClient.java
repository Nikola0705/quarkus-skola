package model.restClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import java.util.List;

@Path("/api/v3")
@RegisterRestClient(configKey = "nager-api")
public interface IPublicHolidayClient {

    @GET
    @Path("/AvailableCountries")
    @Produces(MediaType.APPLICATION_JSON)
    List<CountryDto> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    @Produces(MediaType.APPLICATION_JSON)
    List<PublicHolidayDto> getNextHolidays(@PathParam("countryCode") String countryCode);
}