package com.oesdev.hotels_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDto {

    private Long id;
    private String name;
    private int stars;
    private Long city_id;

}
