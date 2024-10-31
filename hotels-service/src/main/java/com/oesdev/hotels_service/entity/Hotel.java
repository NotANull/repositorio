package com.oesdev.hotels_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {

    private Long id;
    private String name;
    private int stars;
    private Long city_id;

}
