package com.oesdev.hotels_service.service;

import com.oesdev.hotels_service.dto.response.HotelDto;

import java.util.List;

public interface IHotelService {

    List<HotelDto> getHotelsByCityId(Long city_id);
}
