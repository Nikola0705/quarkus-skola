package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.restClient.CountryDto;
import model.restClient.IPublicHolidayClient;
import model.restClient.PublicHolidayDto;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class HolidayService {

    @Inject
    @RestClient
    IPublicHolidayClient client;

    public List<CountryDto> getCountries() {
        return client.getAvailableCountries();
    }

    public List<PublicHolidayDto> getHolidays(String countryCode) {
        return client.getNextHolidays(countryCode);
    }
}