package com.oesdev.cities_service.service;

import com.oesdev.cities_service.dto.response.CityDtoResponse;
import com.oesdev.cities_service.entity.City;
import com.oesdev.cities_service.repository.IHotelsAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImp implements ICityService{

    private final IHotelsAPI hotelsAPI;
    private final List<City> cityList = new ArrayList<>();

    public CityServiceImp(IHotelsAPI hotelsAPI) {
        this.hotelsAPI = hotelsAPI;
    }

    @Override
    @CircuitBreaker(name = "hotels-service", fallbackMethod = "fallbackGetCityHotels")
    @Retry(name = "hotels-service")
    public CityDtoResponse getCityHotels(String name, String country) {

        this.loadCities();

        //1° - Buscar en la lista de ciudades, una ciudad con nombre y país que recibimos por parámetro
        City city = this.cityList.stream()
                .filter(c -> (c.getName().equals(name)) && (c.getCountry().equals(country)))
                .findFirst().orElse(null);

        //2° - devolver la ciudad con la lista de hoteles obtenidos por la API
        CityDtoResponse cityResponse = new CityDtoResponse();
        cityResponse.setCity_id(city.getCity_id());
        cityResponse.setContinent(city.getContinent());
        cityResponse.setName(city.getName());
        cityResponse.setCountry(city.getCountry());
        cityResponse.setState(city.getState());

        //Una vez con la ciudad obtenida, pedir a la API de hoteles que nos de el hotel con el id de la ciudad obtenida
        cityResponse.setHotelsList(this.hotelsAPI.getHotelsByCityId(city.getCity_id()));

        //Sacamos o ponemos la exception para pruebas
        //this.createException();

        return cityResponse;
    }

    //PODRÍA TENER ALGÚN PAQUETE QUE MANEJE ESTE TIPO DE PROBLEMAS?
    public CityDtoResponse fallbackGetCityHotels(Throwable throwable) {
        return new CityDtoResponse(999999L, "Fallido", "Fallido", "Fallido", "Fallido", null);
    }

    //RECUERDOOOOO!!!! HACER UN PAQUETE PARA LAS EXCEPCIONES
    public void createException () {
        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");
    }

    private void loadCities() {

        this.cityList.add(new City(1L, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        this.cityList.add(new City(2L, "Oberá", "South America", "Argentina", "Misiones"));
        this.cityList.add(new City(3L, "Mexico City", "North America", "Mexico", "Mexico City"));
        this.cityList.add(new City(4L, "Guadalajara", "South America", "Mexico", "Jalisco"));
        this.cityList.add(new City(5L, "Guadalajara", "South America", "Colombia", "Cundinamarca"));
        this.cityList.add(new City(6L, "Medellín", "South America", "Colombia", "Antioquia"));
        this.cityList.add(new City(7L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        this.cityList.add(new City(8L, "Valparaíso", "South America", "Chile", "Valparaíso"));
        this.cityList.add(new City(9L, "Asunción", "South America", "Paraguay", "Asunción"));
        this.cityList.add(new City(10L, "Montevideo", "South America", "Uruguay", "Montevideo"));
        this.cityList.add(new City(11L, "Madrid", "Europe", "Spain", "Community of Madrid"));
        this.cityList.add(new City(12L, "Barcelona", "Europe", "Spain", "Catalonia"));
        this.cityList.add(new City(13L, "Seville", "Europe", "Spain", "Andalucia"));
        this.cityList.add(new City(14L, "Monterrey", "North America", "Mexico", "Nuevo León"));
        this.cityList.add(new City(15L, "Valencia", "Europe", "Spain", "Valencian Community"));

    }
}
