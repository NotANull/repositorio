package com.oesdev.cities_service.service;

import com.oesdev.cities_service.dto.response.CityDtoResponse;

public interface ICityService {

    //RECURDO!!! TAMBIÉN PODÍAMOS GENERAR UN NUEVO DTO CON LOS ATRIBUTOS NECESARIOS PARA CADA MÉTOD!
    CityDtoResponse getCityHotels(String name, String country);
}
