package com.nlw.esports.server.models;

import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;
import java.util.List;

public class AdvertisementWithoutDiscord {

    private Long id;

    private Game game;

    private String name;
    private Integer yearsPlaying;

    private List<Integer> weekDays;

    private Instant hourStart;
    private Instant hourEnd;
    private Boolean useVoiceChanel;
    private Instant createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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

    public Instant getHourStart() {
        return hourStart;
    }

    public void setHourStart(Instant hourStart) {
        this.hourStart = hourStart;
    }

    public Instant getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(Instant hourEnd) {
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
