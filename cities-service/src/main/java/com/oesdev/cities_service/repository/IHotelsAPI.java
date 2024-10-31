package com.oesdev.cities_service.repository;

import com.oesdev.cities_service.dto.request.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotels-service")
public interface IHotelsAPI {

    @GetMapping("hotels/{city_id}")
    List<HotelDto> getHotelsByCityId(@PathVariable("city_id") Long city_id);
}
