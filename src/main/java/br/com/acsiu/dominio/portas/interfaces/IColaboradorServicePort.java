package br.com.acsiu.dominio.portas.interfaces;

import java.util.List;

import br.com.acsiu.dominio.dto.ColaboradorDTO;
import br.com.acsiu.dominio.dto.ColaboradorResponseDTO;
import br.com.acsiu.dominio.modelos.Colaborador;

public interface IColaboradorServicePort {

    List<ColaboradorDTO> buscarColaboradores();

    ColaboradorResponseDTO buscarPorNome(String nome);

    void criar(ColaboradorDTO colaboradorDTO);

    void alterar(Integer id, ColaboradorDTO colaboradorDTO);

    void excluir(Integer id);
}
