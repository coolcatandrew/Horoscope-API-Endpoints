package com.liprogramming.horoscopeAPI.Service;

import com.liprogramming.horoscopeAPI.Dao.ZodiacDao;
import com.liprogramming.horoscopeAPI.Model.Zodiac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ZodiacServiceImpl implements ZodiacService {
    @Autowired
    private ZodiacDao zodiacRepository;

    public void setZodiacRepository(ZodiacDao zodiacRepository) {
        this.zodiacRepository = zodiacRepository;
    }

    @Override
    public List<Zodiac> getAll() {
        return (List<Zodiac>) zodiacRepository.findAll();
    }

    @Override
    public Zodiac get(int id) {
        return zodiacRepository.findById(id).get();
    }

    @Override
    public Zodiac get(String sign) {
        List<Zodiac> zodiacs = zodiacRepository.getZodiacBySign(sign);
        //if there are more than one in list it is due to H2 error with api host implementation.
        return zodiacs == null ? null : zodiacs.get(0);
    }

    @Override
    public Zodiac get(int month, int day) {
        //should only have return 2 entries
        for(Zodiac zodiac : zodiacRepository.getZodiacByStartMonthOrEndMonth(month, month)) {
            LocalDate date = LocalDate.of(LocalDate.now().getYear(), month, day);
            if (date.isAfter(zodiac.getStartDate()) && date.isBefore(zodiac.getEndDate())) {
                return zodiac;
            }
        }
        return null;
    }


    @Override
    public void save(Zodiac zodiac) {
        zodiacRepository.save(zodiac);
    }

    @Override
    public void delete(int id) {
        zodiacRepository.deleteById(id);
    }

    @Override
    public void update(Zodiac zodiac) {
        zodiacRepository.save(zodiac);
    }

    @Override
    public Zodiac findBySign(List<Zodiac> zodiacs, String sign) {
        return zodiacs.stream().filter(zodiac -> sign.equals(zodiac.getSign())).findFirst().orElse(null);
    }
}
