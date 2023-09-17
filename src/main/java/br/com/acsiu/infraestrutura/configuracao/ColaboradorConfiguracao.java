package br.com.acsiu.infraestrutura.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.acsiu.dominio.adaptadores.services.ColaboradorServicePortImpI;
import br.com.acsiu.dominio.portas.interfaces.IColaboradorServicePort;
import br.com.acsiu.dominio.portas.repositories.IColaboradorRepositoryPort;

@Configuration
public class ColaboradorConfiguracao {

    @Bean
    public IColaboradorServicePort colaboradorService(IColaboradorRepositoryPort colaboradorRepositoryPort) {
        return new ColaboradorServicePortImpI(colaboradorRepositoryPort);
    }
}
