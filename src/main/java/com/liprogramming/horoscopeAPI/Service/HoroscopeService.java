package com.liprogramming.horoscopeAPI.Service;

import com.liprogramming.horoscopeAPI.Model.Horoscope;

import java.time.LocalDate;
import java.util.List;

public interface HoroscopeService {
    /**
     * Get all Horoscopes
     * @return List<Horoscope>
     */
    public List<Horoscope> getAll();

    /**
     * Get all of todays horoscopes
     * @return
     */
    public List<Horoscope> getToday();

    /**
     * Get Horoscope based on Id
     * @param id
     * @return Horoscope
     */
    public Horoscope get(Long id);

    /**
     * Save horoscope in db
     * @param horoscope
     */
    public void save(Horoscope horoscope);

    /**
     * remove horoscope from db
     * @param id
     */
    public void delete(Long id);

    /**
     * update horoscope in db
     * @param horoscope
     */
    public void update(Horoscope horoscope);

    /**
     * Get todays horoscope based on zodiac id
     * @param zodiacId
     * @return Horoscope
     */
    public Horoscope getToday(Integer zodiacId);
}
