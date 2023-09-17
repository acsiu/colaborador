package br.com.acsiu.dominio.dto;

public class ColaboradorDTO {
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getHierarquia() {
		return hierarquia;
	}

	public void setHierarquia(String hierarquia) {
		this.hierarquia = hierarquia;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getComplexidade() {
		return complexidade;
	}

	public void setComplexidade(String complexidade) {
		this.complexidade = complexidade;
	}

	public ColaboradorDTO() {
	}

	public ColaboradorDTO(Integer id, String nome, String senha, String hierarquia, String vScore, String complexidade) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.hierarquia = hierarquia;
		this.score = vScore;
		this.complexidade = complexidade;
	}

}
