package br.com.acsiu.dominio.dto;

public class ColaboradorResponseDTO {
    private Integer id;
    private String nome;
    private String senha;
    private String hierarquia;
    private String score;
    private String complexidade;
    private Integer idPai;

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

    public Integer getIdPai() {
        return idPai;
    }

    public ColaboradorResponseDTO(){}
    public ColaboradorResponseDTO(Integer id, String nome, String senha, String hierarquia, String score, String complexidade, Integer idPai) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.hierarquia = hierarquia;
        this.score = score;
        this.complexidade = complexidade;
        this.idPai = idPai;
    }
}
