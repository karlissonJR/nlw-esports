package com.nlw.esports.server.controllers;

import com.nlw.esports.server.dto.AdvertisementDto;
import com.nlw.esports.server.models.Advertisement;
import com.nlw.esports.server.services.AdvertisementService;
import com.nlw.esports.server.services.GameService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ads")
public class AdvertisementController {

    @Autowired
    AdvertisementService service;

    @Autowired
    GameService gameService;

    @GetMapping("/{id}/discord")
    public ResponseEntity<String> findDiscordByAdvertisement(@PathVariable(value = "id") Long id) {
        Advertisement advertisement = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(advertisement.getDiscord());
    }

    @PostMapping
    public ResponseEntity<Advertisement> save(@RequestBody AdvertisementDto advertisementDto) {

        Advertisement advertisement = new Advertisement();
        BeanUtils.copyProperties(advertisementDto, advertisement);

        advertisement.setGame(gameService.findById(advertisementDto.getGameId()));
        advertisement.setHourStart(Instant.parse(advertisementDto.getHourStart()));
        advertisement.setHourEnd(Instant.parse(advertisementDto.getHourEnd()));
        advertisement.setCreatedAt(Instant.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(advertisement));
    }

}
