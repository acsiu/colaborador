package br.com.acsiu.dominio.adaptadores.services;

import java.util.List;
import java.util.stream.Collectors;

import br.com.acsiu.dominio.dto.ColaboradorDTO;
import br.com.acsiu.dominio.dto.ColaboradorResponseDTO;
import br.com.acsiu.dominio.dto.ResultPasswordDTO;
import br.com.acsiu.dominio.modelos.Colaborador;
import br.com.acsiu.dominio.portas.interfaces.IColaboradorServicePort;
import br.com.acsiu.dominio.portas.repositories.IColaboradorRepositoryPort;
import br.com.acsiu.dominio.util.PasswordUtil;

public class ColaboradorServicePortImpI implements IColaboradorServicePort {

    private final IColaboradorRepositoryPort colaboradorRepository;

    public ColaboradorServicePortImpI(IColaboradorRepositoryPort colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public void criar(ColaboradorDTO dto) {
        var colaborador = getColaborador(dto);
        this.colaboradorRepository.criar(colaborador);
    }

    @Override
    public void alterar(Integer id, ColaboradorDTO dto) {
        var colaborador = getColaborador(dto);
        this.colaboradorRepository.alterar(id, colaborador);
    }

    @Override
    public void excluir(Integer id) {
        colaboradorRepository.excluir(id);
    }

    private static Colaborador getColaborador(ColaboradorDTO dto) {
        ResultPasswordDTO resultPasswordDTO = PasswordUtil.nivelSenha(dto.getSenha());
        dto.setSenha(PasswordUtil.encoder(dto.getSenha()));
        dto.setScore(resultPasswordDTO.getScore());
        dto.setComplexidade(resultPasswordDTO.getStatus());
        var colaborador = new Colaborador(dto);
        return colaborador;
    }

    public List<ColaboradorDTO> buscarColaboradores() {
        List<Colaborador> colaboradores = this.colaboradorRepository.buscarTodos();
        List<ColaboradorDTO> colaboradoresDTO = colaboradores.stream().map(Colaborador::toColaboradorDTO).collect(Collectors.toList());
        return colaboradoresDTO;
    }

    @Override
    public ColaboradorResponseDTO buscarPorNome(String nome) {
        var colaborador = this.colaboradorRepository.buscarPorNome(nome);
        var response = new ColaboradorResponseDTO(colaborador.getId(), colaborador.getNome(), colaborador.getSenha(), colaborador.getHierarquia(), colaborador.getScore(), colaborador.getComplexidade(), colaborador.getIdPai());
        return response;
    }


}
