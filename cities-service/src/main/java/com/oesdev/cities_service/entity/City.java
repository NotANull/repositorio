package com.oesdev.cities_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {

    private Long city_id;
    private String name;
    private String continent;
    private String country;
    private String state;

}
