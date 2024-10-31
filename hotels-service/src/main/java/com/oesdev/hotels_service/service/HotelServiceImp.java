package com.oesdev.hotels_service.service;


import com.oesdev.hotels_service.dto.response.HotelDto;
import com.oesdev.hotels_service.entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImp implements IHotelService{

    private final List<Hotel> hotelList = new ArrayList<>();

    @Override
    public List<HotelDto> getHotelsByCityId(Long city_id) {

        this.loadHotels();

        List<Hotel> filteredHotelList =  this.hotelList.stream()
                .filter(h -> h.getCity_id().equals(city_id))
                .toList();

        List<HotelDto> hotelDtoList = new ArrayList<>();
        for (Hotel h : filteredHotelList) {
            hotelDtoList.add(new HotelDto(h.getId(), h.getName(), h.getStars(), h.getCity_id()));
        }

        return hotelDtoList;

    }

    private void loadHotels() {
        this.hotelList.add(new Hotel(1L, "Paradise", 5, 1L));
        this.hotelList.add(new Hotel(2L, "Sunset View", 4, 2L));
        this.hotelList.add(new Hotel(3L, "Ocean Breeze", 3, 3L));
        this.hotelList.add(new Hotel(4L, "Mountain Retreat", 4, 1L));
        this.hotelList.add(new Hotel(5L, "City Lights Inn", 3, 2L));
        this.hotelList.add(new Hotel(6L, "Reverside Lodge", 4, 3L));
        this.hotelList.add(new Hotel(7L, "Cozy Cabin Resort", 2, 1L));
        this.hotelList.add(new Hotel(8L, "Luxury Haven", 5, 2L));
        this.hotelList.add(new Hotel(9L, "Historic Grand Hotel", 4, 3L));
        this.hotelList.add(new Hotel(10L, "Tranquil Gardens", 3, 1L));
    }
}
