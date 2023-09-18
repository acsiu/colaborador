package br.com.acsiu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.acsiu.infraestrutura.adaptadores.interfaces.IColaboradorRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = IColaboradorRepository.class)
public class ArquiteturaHexagonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArquiteturaHexagonalApplication.class, args);
    }
}
