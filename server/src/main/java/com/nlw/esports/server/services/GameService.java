package com.nlw.esports.server.services;

import com.nlw.esports.server.models.Game;
import com.nlw.esports.server.models.GameWithAdvertisementsCount;
import com.nlw.esports.server.repositories.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService{

    @Autowired
    GameRepository repository;

    @Autowired
    AdvertisementService advertisementService;

    public List<GameWithAdvertisementsCount> findAll() {

        List<Game> games = repository.findAll();
        List<GameWithAdvertisementsCount> gameWithAdvertisementsCounts = new ArrayList<>();

        games.forEach(game -> {

            GameWithAdvertisementsCount gameWithAdvertisementsCount = new GameWithAdvertisementsCount();
            BeanUtils.copyProperties(game, gameWithAdvertisementsCount);
            gameWithAdvertisementsCount.setAdvertisements(advertisementService.findByGameId(game.getId()).size());

            gameWithAdvertisementsCounts.add(gameWithAdvertisementsCount);
        });

        return gameWithAdvertisementsCounts;
    }

    public Game findById(Long id) {
        return repository.findById(id).get();
    }

    public Game save(Game game) {
        return repository.save(game);
    }
}
