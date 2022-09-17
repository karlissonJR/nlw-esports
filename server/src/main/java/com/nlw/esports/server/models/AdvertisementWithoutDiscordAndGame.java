package com.nlw.esports.server.models;

import java.time.Instant;
import java.util.List;

public class AdvertisementWithoutDiscordAndGame {

    private Long id;

    private String name;
    private Integer yearsPlaying;

    private List<Integer> weekDays;

    private String hourStart;
    private String hourEnd;
    private Boolean useVoiceChanel;
    private Instant createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearsPlaying() {
        return yearsPlaying;
    }

    public void setYearsPlaying(Integer yearsPlaying) {
        this.yearsPlaying = yearsPlaying;
    }

    public List<Integer> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(List<Integer> weekDays) {
        this.weekDays = weekDays;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public Boolean getUseVoiceChanel() {
        return useVoiceChanel;
    }

    public void setUseVoiceChanel(Boolean useVoiceChanel) {
        this.useVoiceChanel = useVoiceChanel;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
