package com.liprogramming.horoscopeAPI.Parser;

import com.liprogramming.horoscopeAPI.Model.Horoscope;
import com.liprogramming.horoscopeAPI.Model.Zodiac;
import com.liprogramming.horoscopeAPI.Service.HoroscopeService;
import com.liprogramming.horoscopeAPI.Service.ZodiacService;
import com.liprogramming.horoscopeAPI.Utils.RssReader;
import com.sun.syndication.feed.synd.SyndEntry;

import java.util.ArrayList;
import java.util.List;

public class AstrologyDotComFeedParser implements FeedParser {
    private RssReader reader;
    private final String url = "https://www.astrology.com/us/offsite/rss/daily-extended.aspx";
    private ZodiacService zodiacService;
    private HoroscopeService horoscopeService;

    public AstrologyDotComFeedParser() {
    }

    public AstrologyDotComFeedParser(ZodiacService zodiacService, HoroscopeService horoscopeService) {
        reader = new RssReader(url);
        this.zodiacService = zodiacService;
        this.horoscopeService = horoscopeService;
    }

    @Override
    public void setHoroscopeService(HoroscopeService horoscopeService) {
        this.horoscopeService = horoscopeService;
    }

    @Override
    public void setZodiacService(ZodiacService zodiacService) {
        this.zodiacService = zodiacService;
    }

    /**
     * Parse data from the rss feed
     * @return
     */
    public List<Horoscope> parseData() {
        List<Horoscope> horoscopes = new ArrayList<>();
        List<SyndEntry> entries = reader.getFeed().getEntries();
        List<Zodiac> zodiacs = zodiacService.getAll();
        for (SyndEntry entry : entries) {
            String title = entry.getTitle(); //first word is zodiac sign and end is date. (eg. Aries Daily Horoscope for February 12, 2020)
            String sign = title.split(" ")[0].toUpperCase();
            String content = entry.getDescription().getValue().split("</p>")[0]; //only get first <p> of description
            content = "".equals(content) ? "" : content.replace("<p>", ""); //remove initial <p>
            Zodiac zodiac = zodiacService.findBySign(zodiacs, sign);
            if (zodiac == null) {
                return null;
            }
            horoscopes.add(new Horoscope(zodiac.getId(), content, HoroscopeSources.ASTROLOGY_DOT_COM.getSourceName()));
        }
        return horoscopes.size() == 0 ? null : horoscopes;
    }


}
