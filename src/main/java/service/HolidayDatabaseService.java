package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.HolidayType;
import model.PublicHoliday;
import model.restClient.PublicHolidayDto;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class HolidayDatabaseService {

    @Inject
    EntityManager em;

    @Transactional
    public void saveToDatabase(List<PublicHolidayDto> dtos) {
        for (PublicHolidayDto dto : dtos) {
            int year = Integer.parseInt(dto.date.substring(0, 4));
            boolean exists = em.createQuery("SELECT COUNT(h) FROM PublicHoliday h WHERE h.date = :date AND h.countryCode = :code", Long.class)
                .setParameter("date", dto.date)
                .setParameter("code", dto.countryCode)
                .getSingleResult() > 0;

            if (!exists) {
                PublicHoliday h = new PublicHoliday();
                h.date = dto.date;
                h.localName = dto.localName;
                h.name = dto.name;
                h.countryCode = dto.countryCode;
                h.fixed = dto.fixed;
                h.global = dto.global;
                h.year = year;

                List<HolidayType> types = new ArrayList<>();
                for (String typeStr : dto.types) {
                    HolidayType ht = new HolidayType();
                    ht.type = typeStr;
                    ht.holiday = h;
                    types.add(ht);
                }

                h.types = types;
                em.persist(h);
            }
        }
    }
}