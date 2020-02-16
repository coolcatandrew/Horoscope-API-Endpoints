package com.liprogramming.horoscopeAPI.Controller;

import com.liprogramming.horoscopeAPI.Parser.AstrologyDotComFeedParser;
import com.liprogramming.horoscopeAPI.Parser.FeedParser;
import com.liprogramming.horoscopeAPI.Model.Horoscope;
import com.liprogramming.horoscopeAPI.Model.Zodiac;
import com.liprogramming.horoscopeAPI.Parser.HoroscopeSources;
import com.liprogramming.horoscopeAPI.Service.HoroscopeService;
import com.liprogramming.horoscopeAPI.Service.ZodiacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class HoroscopeAPIController {
    private FeedParser parser;

    @Autowired
    private HoroscopeService horoscopeService;

    public void setHoroscopeService(HoroscopeService horoscopeService) {
        this.horoscopeService = horoscopeService;
    }

    @Autowired
    private ZodiacService zodiacService;

    public void setZodiacService(ZodiacService zodiacService) {
        this.zodiacService = zodiacService;
    }

    /**
     * Get all zodiacs
     * @return
     */
    @GetMapping("zodiac")
    private ResponseEntity<List<Zodiac>> getZodiacs() {
        try{
            return new ResponseEntity<>(zodiacService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get all of todays horoscopes
     * @return
     */
    @GetMapping("horoscopes")
    private List<Horoscope> getHoroscopes() {
        List<Horoscope> horoscopes = horoscopeService.getToday();
        if (horoscopes == null || horoscopes.size() == 0) {
            loadHoroscopes(HoroscopeSources.ASTROLOGY_DOT_COM);  //change source when more implemented
            horoscopes = horoscopeService.getToday();
        }
        return horoscopes;
    }

    /**
     * Get horoscope based on zodiac sign
     * @param sign
     * @return
     */
    @GetMapping("sign/{sign}")
    private ResponseEntity<Horoscope> getToday(@PathVariable("sign") String sign) {
        return new ResponseEntity<>(getTodaysHoroscope(zodiacService.get(sign.toUpperCase())), HttpStatus.OK);
    }

    /**
     * Get horoscope based on birthday
     * @param month
     * @param day
     * @return
     */
    @GetMapping("month/{month}/day/{day}")
    private ResponseEntity<Horoscope> getToday(@PathVariable("month") Integer month, @PathVariable("day") Integer day) {
        return new ResponseEntity<>(getTodaysHoroscope(zodiacService.get(month, day)), HttpStatus.OK);
    }

    private Horoscope getTodaysHoroscope(Zodiac zodiac) {
        Horoscope horoscope = horoscopeService.getToday(zodiac.getId());
        if (horoscope == null) {
            loadHoroscopes(HoroscopeSources.ASTROLOGY_DOT_COM);  //change source when more implemented
            horoscope = horoscopeService.getToday(zodiac.getId());
        }
        return horoscope;
    }

    private List<Horoscope> loadHoroscopes(HoroscopeSources source) {
        setParser(source);
        for (Horoscope horoscope : parser.parseData()) {
            horoscopeService.save(horoscope);
        }
        return horoscopeService.getAll();
    }

    private void setParser(HoroscopeSources source) {
        switch (source) {
            case ASTROLOGY_DOT_COM:
                parser = new AstrologyDotComFeedParser(zodiacService, horoscopeService);
                break;
            default:
                parser = new AstrologyDotComFeedParser(zodiacService, horoscopeService);
        }
    }

}
