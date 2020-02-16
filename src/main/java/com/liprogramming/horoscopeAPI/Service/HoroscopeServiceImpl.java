package com.liprogramming.horoscopeAPI.Service;

import com.liprogramming.horoscopeAPI.Dao.HoroscopeDao;
import com.liprogramming.horoscopeAPI.Model.Horoscope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HoroscopeServiceImpl implements HoroscopeService{

    @Autowired
    private HoroscopeDao horoscopeRepository;

    public void setHoroscopeRepository(HoroscopeDao horoscopeRepository) {
        this.horoscopeRepository = horoscopeRepository;
    }

    @Override
    public List<Horoscope> getAll() {
        return (List<Horoscope>) horoscopeRepository.findAll();
    }

    @Override
    public List<Horoscope> getToday() {
        return horoscopeRepository.getAllByCreatedEquals(LocalDate.now());
    }

    @Override
    public Horoscope get(Long id) {
        return horoscopeRepository.findById(id).get();
    }

    @Override
    public void save(Horoscope horoscope) {
        horoscopeRepository.save(horoscope);
    }

    @Override
    public void delete(Long id) {
        horoscopeRepository.deleteById(id);
    }

    @Override
    public void update(Horoscope horoscope) {
        horoscopeRepository.save(horoscope);
    }

    @Override
    public Horoscope getToday(Integer zodiacId) {
        return horoscopeRepository.getToday(zodiacId, LocalDate.now());
    }
}
