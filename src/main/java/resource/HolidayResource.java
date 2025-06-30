package resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.restClient.CountryDto;
import model.restClient.PublicHolidayDto;
import service.HolidayService;

import java.util.List;

@Path("/holidays")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HolidayResource {

    @Inject
    HolidayService service;

    @GET
    @Path("/countries")
    public List<CountryDto> getCountries() {
        return service.getCountries();
    }

    @GET
    @Path("/next/{code}")
    public List<PublicHolidayDto> getHolidays(@PathParam("code") String code) {
        return service.getHolidays(code);
    }
}