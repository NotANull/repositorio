package com.oesdev.hotels_service.controller;

import com.oesdev.hotels_service.dto.response.HotelDto;
import com.oesdev.hotels_service.service.IHotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final IHotelService hotelService;

    public HotelController(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/{city_id}")
    public List<HotelDto> getHotelsByCityId(@PathVariable Long city_id) {
        return this.hotelService.getHotelsByCityId(city_id);
    }
}
