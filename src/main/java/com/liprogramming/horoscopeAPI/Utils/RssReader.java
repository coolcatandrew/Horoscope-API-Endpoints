package com.liprogramming.horoscopeAPI.Utils;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

public class RssReader {
    Logger logger = LoggerFactory.getLogger(RssReader.class);
    private SyndFeed feed;

    public RssReader(String sourceUrl) {
        try {
            URL feedSource = new URL(sourceUrl);
            SyndFeedInput input = new SyndFeedInput();
            feed = input.build(new XmlReader(feedSource));
        } catch (IOException | FeedException e) {
            logger.error(e.getMessage());
        }
    }

    public SyndFeed getFeed() {
        return feed;
    }

}
