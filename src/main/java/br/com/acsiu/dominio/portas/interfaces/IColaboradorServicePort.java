package br.com.acsiu.dominio.portas.interfaces;

import br.com.acsiu.dominio.dto.ColaboradorDTO;
import br.com.acsiu.dominio.dto.ColaboradorResponseDTO;

import java.util.List;

public interface IColaboradorServicePort {

    List<ColaboradorDTO> buscarColaboradores();

    ColaboradorResponseDTO buscarPorNome(String nome);

    void criar(ColaboradorDTO colaboradorDTO);

    void alterar(Integer id, ColaboradorDTO colaboradorDTO);

    void excluir(Integer id);
}
