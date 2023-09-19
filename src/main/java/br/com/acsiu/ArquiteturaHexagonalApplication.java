package br.com.acsiu;

import br.com.acsiu.infraestrutura.adaptadores.interfaces.IColaboradorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = IColaboradorRepository.class)
public class ArquiteturaHexagonalApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(ArquiteturaHexagonalApplication.class, args);
    }
}
