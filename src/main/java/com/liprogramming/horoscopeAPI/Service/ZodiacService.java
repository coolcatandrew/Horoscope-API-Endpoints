package com.liprogramming.horoscopeAPI.Service;
import com.liprogramming.horoscopeAPI.Model.Zodiac;

import java.util.List;

public interface ZodiacService {
    /**
     * Get all zodiac entries
     * @return List<Zodiac>
     */
    public List<Zodiac> getAll();

    /**
     * Get zodiac by id
     * @param id
     * @return Zodiac
     */
    public Zodiac get(int id);

    /**
     * Get zodiac by sign
     * @param sign (Upper case)
     * @return Zodiac
     */
    public Zodiac get(String sign);

    /**
     * Get zodiacs by month and day
     * @param month
     * @param day
     * @return Zodiac
     */
    public Zodiac get(int month, int day);

    /**
     * Save zodiac to DB
     * @param zodiac
     */
    public void save(Zodiac zodiac);

    /**
     * Remove Zodiac by id
     * @param id
     */
    public void delete(int id);

    /**
     * Update Zodiac in DB
     * @param zodiac
     */
    public void update(Zodiac zodiac);

    /**
     * get a Zodiac from a list of zodiacs with a specific sign
     * @param zodiacs
     * @param sign
     * @return Zodiac
     */
    public Zodiac findBySign(List<Zodiac> zodiacs, String sign);
}
