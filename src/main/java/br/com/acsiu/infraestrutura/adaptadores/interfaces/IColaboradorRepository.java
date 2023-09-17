package br.com.acsiu.infraestrutura.adaptadores.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acsiu.infraestrutura.adaptadores.entidades.ColaboradorEntity;

@Repository
public interface IColaboradorRepository extends JpaRepository<ColaboradorEntity, Integer> {
    Optional<ColaboradorEntity> findByNome(String nome);
}
