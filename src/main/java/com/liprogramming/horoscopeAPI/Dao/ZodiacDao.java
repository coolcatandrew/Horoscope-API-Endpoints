package com.liprogramming.horoscopeAPI.Dao;

import com.liprogramming.horoscopeAPI.Model.Zodiac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZodiacDao extends JpaRepository<Zodiac, Integer> {

    public List<Zodiac> getZodiacBySign(String sign);

    public List<Zodiac> getZodiacByStartMonthOrEndMonth(Integer firstMonth, Integer secondMonth);
}
