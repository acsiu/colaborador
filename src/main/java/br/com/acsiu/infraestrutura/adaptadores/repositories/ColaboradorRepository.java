package br.com.acsiu.infraestrutura.adaptadores.repositories;

import br.com.acsiu.dominio.exceptions.RegistroNotFoundException;
import br.com.acsiu.dominio.modelos.Colaborador;
import br.com.acsiu.dominio.portas.repositories.IColaboradorRepositoryPort;
import br.com.acsiu.dominio.util.Utils;
import br.com.acsiu.infraestrutura.adaptadores.entidades.ColaboradorEntity;
import br.com.acsiu.infraestrutura.adaptadores.interfaces.IColaboradorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ColaboradorRepository implements IColaboradorRepositoryPort {

    private final IColaboradorRepository colaboradorRepository;

    public ColaboradorRepository(IColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    @Override
    public List<Colaborador> buscarTodos() {
        List<ColaboradorEntity> ColaboradorEntities = this.colaboradorRepository.findAll();
        return ColaboradorEntities.stream().map(ColaboradorEntity::toColaborador).collect(Collectors.toList());
    }

    @Override
    public Colaborador buscarPorNome(String nome) {
        ColaboradorEntity colaboradorEntity = this.colaboradorRepository.findByNome(nome).orElseThrow(() -> new RegistroNotFoundException(Utils.getMessage("nenhum.registro.encontrado")));
        return colaboradorEntity.toColaborador();
    }

    @Override
    public void criar(Colaborador colaborador) {
    	var colaboradorEntity = new ColaboradorEntity(colaborador);
        this.colaboradorRepository.save(colaboradorEntity);
    }

    @Override
    public void alterar(Integer id, Colaborador colaborador) {
        var colaboradorEntity = this.colaboradorRepository.findById(id).get();
        var obj = new Colaborador(id, colaborador.getNome(), colaborador.getSenha(), colaborador.getHierarquia(), colaborador.getScore(), colaborador.getComplexidade(), colaborador.getIdPai());
        colaboradorEntity.atualizar(obj);
        this.colaboradorRepository.save(colaboradorEntity);
    }

    @Override
    public void excluir(Integer id) {
        this.colaboradorRepository.delete(this.colaboradorRepository.findById(id).get());
    }

}
