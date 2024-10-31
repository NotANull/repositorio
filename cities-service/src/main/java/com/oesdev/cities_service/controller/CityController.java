package com.oesdev.cities_service.controller;

import com.oesdev.cities_service.dto.response.CityDtoResponse;
import com.oesdev.cities_service.service.ICityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    private ICityService cityService;

    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/hotels")
    public CityDtoResponse getCityHotels(@RequestParam String name, @RequestParam String country) {
        return this.cityService.getCityHotels(name, country);
    }
}
