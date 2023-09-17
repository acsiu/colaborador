package br.com.acsiu.dominio.modelos;

import br.com.acsiu.dominio.dto.ColaboradorDTO;

public class Colaborador {

	private Integer id;
	private String nome;
	private String senha;
	private String hierarquia;
	private String score;
	private String complexidade;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public String getHierarquia() {
		return hierarquia;
	}

	public String getScore() {
		return score;
	}

	public String getComplexidade() {
		return complexidade;
	}

	public Colaborador(Integer id, String nome, String senha, String hierarquia, String score, String complexidade) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.hierarquia = hierarquia;
		this.score = score;
		this.complexidade = complexidade;
	}

	public Colaborador(ColaboradorDTO dto) {
		this.nome = dto.getNome();
		this.senha = dto.getSenha();
		this.hierarquia = dto.getHierarquia();
		this.score = dto.getScore();
		this.complexidade = dto.getComplexidade();
	}

	public ColaboradorDTO toColaboradorDTO() {
		return new ColaboradorDTO(this.id, this.nome, this.senha, this.hierarquia, this.score, this.complexidade);
	}
}
