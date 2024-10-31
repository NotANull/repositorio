package com.oesdev.cities_service.dto.response;

import com.oesdev.cities_service.dto.request.HotelDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityDtoResponse {

    private Long city_id;
    private String name;
    private String continent;
    private String country;
    private String state;
    private List<HotelDto> hotelsList;
}
