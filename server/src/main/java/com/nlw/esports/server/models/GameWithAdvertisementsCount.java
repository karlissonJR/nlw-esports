package com.nlw.esports.server.models;

public class GameWithAdvertisementsCount extends Game {

    private Integer advertisements;

    public GameWithAdvertisementsCount(Long id, String title, String bannerUrl, Integer advertisements) {
        super(id, title, bannerUrl);
        this.advertisements = advertisements;
    }

    public Integer getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(Integer advertisements) {
        this.advertisements = advertisements;
    }
}
