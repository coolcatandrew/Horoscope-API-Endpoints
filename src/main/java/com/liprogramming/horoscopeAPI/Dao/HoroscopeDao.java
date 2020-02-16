package com.liprogramming.horoscopeAPI.Dao;

import com.liprogramming.horoscopeAPI.Model.Horoscope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HoroscopeDao extends JpaRepository<Horoscope, Long> {

    @Query("SELECT h FROM Horoscope h WHERE zodiacId = ?1 AND created = ?2")
    public Horoscope getToday(Integer zodiacId, LocalDate date);

    public List<Horoscope> getAllByCreatedEquals(LocalDate today);
}
