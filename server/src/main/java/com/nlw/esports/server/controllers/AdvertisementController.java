package com.nlw.esports.server.controllers;

import com.nlw.esports.server.models.Advertisement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ads")
public class AdvertisementController {

    @GetMapping
    public ResponseEntity<List<Advertisement>> index() {

        List<Advertisement> advertisements = new ArrayList<>();

        advertisements.add(new Advertisement(1L, "Anúncio 1"));
        advertisements.add(new Advertisement(2L, "Anúncio 2"));
        advertisements.add(new Advertisement(3L, "Anúncio 3"));
        advertisements.add(new Advertisement(4L, "Anúncio 4"));
        advertisements.add(new Advertisement(5L, "Anúncio 5"));

        return ResponseEntity.status(HttpStatus.OK).body(advertisements);
    }

}
