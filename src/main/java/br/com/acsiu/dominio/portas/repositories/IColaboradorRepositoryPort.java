package br.com.acsiu.dominio.portas.repositories;

import java.util.List;

import br.com.acsiu.dominio.modelos.Colaborador;

public interface IColaboradorRepositoryPort {

	List<Colaborador> buscarTodos();

	Colaborador buscarPorNome(String nome);

	void criar(Colaborador colaborador);

	void alterar(Integer id, Colaborador colaborador);
	void excluir(Integer id);
}
