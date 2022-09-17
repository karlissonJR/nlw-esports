package com.nlw.esports.server.services;

import com.nlw.esports.server.models.Advertisement;
import com.nlw.esports.server.models.AdvertisementWithoutDiscordAndGame;
import com.nlw.esports.server.repositories.AdvertisementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementService {

    @Autowired
    AdvertisementRepository repository;

    public Advertisement findById(Long id) {
        return  repository.findById(id).get();
    }

    public List<AdvertisementWithoutDiscordAndGame> findByGameId(Long gameId) {

        List<Advertisement> allAdvertisements = repository.findAll();
        List<Advertisement> advertisementsByGameId = allAdvertisements.stream()
                .filter(advertisement -> advertisement.getGame().getId() == gameId)
                .collect(Collectors.toList());

        List<AdvertisementWithoutDiscordAndGame> advertisementWithoutDiscordAndGames = new ArrayList<>();
        advertisementsByGameId.forEach(advertisement -> {
            AdvertisementWithoutDiscordAndGame advertisementWithoutDiscordAndGame = new AdvertisementWithoutDiscordAndGame();
            BeanUtils.copyProperties(advertisement, advertisementWithoutDiscordAndGame);

            advertisementWithoutDiscordAndGames.add(advertisementWithoutDiscordAndGame);
        });

        return advertisementWithoutDiscordAndGames;
    }

    public Advertisement save(Advertisement advertisement) {
        return repository.save(advertisement);
    }

}
