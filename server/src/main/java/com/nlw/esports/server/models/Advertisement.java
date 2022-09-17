package com.nlw.esports.server.models;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private String name;
    private Integer yearsPlaying;
    private String discord;

    @ElementCollection
    private List<Integer> weekDays;

    private String hourStart;
    private String hourEnd;
    private Boolean useVoiceChanel;
    private Instant createdAt;

    public Advertisement() {}

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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", game=" + game +
                ", name='" + name + '\'' +
                ", yearsPlaying=" + yearsPlaying +
                ", discord='" + discord + '\'' +
                ", weekDays=" + weekDays +
                ", hourStart=" + hourStart +
                ", hourEnd=" + hourEnd +
                ", useVoiceChanel=" + useVoiceChanel +
                ", createdAt=" + createdAt +
                '}';
    }
}
