# Horoscope-API-Endpoints
Get daily horoscopes from rss feeds. 

Used in Daily-Horoscope-API.

Currently only astrology.com source supported but more to come!

## Endpoints


    /**
     * Get all zodiacs
     */
    @GetMapping("/api/zodiac")
    
    /**
     * Get all of todays horoscopes
     */
    @GetMapping("/api/horoscopes")

    /**
     * Get todays horoscope based on zodiac sign
     * Sign is a String (eg. leo, aquarius)
     */
    @GetMapping("/api/{sign}")

    /**
     * Get todays horoscope based on birthday
     * month is a Integer of the birth month (eg. 2 for February)
     * day is a Integer of the birth day (eg. 19 for the 19th day of the month)
     */
    @GetMapping("/api/month/{month}/day/{day}")
    
