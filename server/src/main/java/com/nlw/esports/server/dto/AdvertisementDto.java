package com.nlw.esports.server.dto;

import java.util.List;

public class AdvertisementDto {

    private Long gameId;
    private String name;
    private Integer yearsPlaying;
    private String discord;
    private List<Integer> weekDays;
    private String hourStart;
    private String hourEnd;
    private Boolean useVoiceChanel;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
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

    public String getDiscord() {
        return discord;
    }

    public void setDiscord(String discord) {
        this.discord = discord;
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
}
