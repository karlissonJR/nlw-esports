package com.nlw.esports.server.controllers;

import com.nlw.esports.server.dto.GameDto;
import com.nlw.esports.server.models.AdvertisementWithoutDiscordAndGame;
import com.nlw.esports.server.models.Game;
import com.nlw.esports.server.models.GameWithAdvertisementsCount;
import com.nlw.esports.server.services.AdvertisementService;
import com.nlw.esports.server.services.GameService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameService service;

    @Autowired
    AdvertisementService advertisementService;

    @GetMapping
    public ResponseEntity<List<GameWithAdvertisementsCount>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{gameId}/ads")
    public ResponseEntity<List<AdvertisementWithoutDiscordAndGame>> findAdvertisementsByGame(@PathVariable(value = "gameId") Long gameId) {
        List<AdvertisementWithoutDiscordAndGame> advertisements = advertisementService.findByGameId(gameId);
        return ResponseEntity.status(HttpStatus.OK).body(advertisements);
    }

    @PostMapping
    public ResponseEntity<Game> save(@RequestBody GameDto gameDto) {

        Game game = new Game();
        BeanUtils.copyProperties(gameDto, game);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(game));
    }

}
