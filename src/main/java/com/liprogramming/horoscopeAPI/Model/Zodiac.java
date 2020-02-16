package com.liprogramming.horoscopeAPI.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table
public class Zodiac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sign")
    private String sign;
    @Column(name = "STARTMONTH")
    private Integer startMonth;
    @Column(name = "STARTDAY")
    private Integer startDay;
    @Column(name = "ENDMONTH")
    private Integer endMonth;
    @Column(name = "ENDDAY")
    private Integer endDay;

    public Zodiac() {
    }

    public Zodiac(String sign, int startMonth, int startDay, int endMonth, int endDay) {
        this.sign = sign;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.endMonth = endMonth;
        this.endDay = endDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public LocalDate getStartDate() {
        return LocalDate.of(LocalDate.now().getYear(), startMonth, startDay);
    }

    public LocalDate getEndDate() {
        return LocalDate.of(LocalDate.now().getYear(), endMonth, endDay);
    }
}
