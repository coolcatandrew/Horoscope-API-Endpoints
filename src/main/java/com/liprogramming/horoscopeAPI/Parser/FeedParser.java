package com.liprogramming.horoscopeAPI.Parser;

import com.liprogramming.horoscopeAPI.Model.Horoscope;
import com.liprogramming.horoscopeAPI.Service.HoroscopeService;
import com.liprogramming.horoscopeAPI.Service.ZodiacService;

import java.util.List;

public interface FeedParser {
    public void setHoroscopeService(HoroscopeService horoscopeService);
    public void setZodiacService(ZodiacService zodiacService);
    public List<Horoscope> parseData();
}
