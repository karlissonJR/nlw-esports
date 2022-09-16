package com.nlw.esports.server.services;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.nlw.esports.server.models.Advertisement;
import com.nlw.esports.server.models.AdvertisementWithoutDiscord;
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

    public List<AdvertisementWithoutDiscord> findByGameId(Long gameId) {

        List<Advertisement> allAdvertisements = repository.findAll();
        List<Advertisement> advertisementsByGameId = allAdvertisements.stream()
                .filter(advertisement -> advertisement.getGame().getId() == gameId)
                .collect(Collectors.toList());

        List<AdvertisementWithoutDiscord> advertisementWithoutDiscords = new ArrayList<>();
        advertisementsByGameId.forEach(advertisement -> {
            AdvertisementWithoutDiscord advertisementWithoutDiscord = new AdvertisementWithoutDiscord();
            BeanUtils.copyProperties(advertisement, advertisementWithoutDiscord);

            advertisementWithoutDiscords.add(advertisementWithoutDiscord);
        });

        return advertisementWithoutDiscords;
    }

    public Advertisement save(Advertisement advertisement) {
        return repository.save(advertisement);
    }

}
