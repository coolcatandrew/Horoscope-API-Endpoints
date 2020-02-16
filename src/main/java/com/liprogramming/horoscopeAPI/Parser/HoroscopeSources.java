package com.liprogramming.horoscopeAPI.Parser;

public enum HoroscopeSources {
    ASTROLOGY_DOT_COM("www.astrology.com");

    private final String sourceName;

    HoroscopeSources(String name) {
        sourceName = name;
    }

    public String getSourceName() {
        return sourceName;
    }
}
