package com.deliverytech.delivery_api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.repository.RestauranteRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final RestauranteRepository restauranteRepository;

    public DataLoader(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public void run(String... args) {

        if (restauranteRepository.count() == 0) {

            restauranteRepository.save(
                new Restaurante("Pizzaria Bella Massa", "Pizza", 4.8, true));

            restauranteRepository.save(
                new Restaurante("Top Burger", "Hamburguer", 4.6, true));

            restauranteRepository.save(
                new Restaurante("Sushi House", "Japonesa", 4.9, false));

            System.out.println("======================================");
            System.out.println("Restaurantes cadastrados com sucesso!");
            System.out.println("======================================");
        }
    }
}
