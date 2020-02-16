package com.liprogramming.horoscopeAPI.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Horoscope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ZODIACID")
    private Integer zodiacId;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "CREATED")
    private LocalDate created;
    @Column(name = "SOURCE")
    private String source;

    public Horoscope() {
    }

    public Horoscope(Integer zodiacId, String content) {
        this(zodiacId, content, LocalDate.now(), "");
    }

    public Horoscope(Integer zodiacId, String content, String source) {
        this(zodiacId, content, LocalDate.now(), source);
    }

    public Horoscope(Integer zodiacId, String content, LocalDate created) {
       this(zodiacId, content, created, "");
    }

    public Horoscope(Integer zodiacId, String content, LocalDate created, String source) {
        this.zodiacId = zodiacId;
        this.content = content;
        this.created = created;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getZodiacId() {
        return zodiacId;
    }

    public void setZodiacId(Integer zodiacId) {
        this.zodiacId = zodiacId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
