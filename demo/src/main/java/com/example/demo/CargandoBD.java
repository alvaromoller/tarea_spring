

package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class CargandoBD {

    @Bean
    CommandLineRunner initDatabase(Repositorio_Medico repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Medico("Jose", "especialidad1","cargo1")));
            log.info("Preloading " + repository.save(new Medico("David", "especialidad2","cargo2")));
        };
    }
}