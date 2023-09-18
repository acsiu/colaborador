package br.com.acsiu.infraestrutura.adaptadores.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import br.com.acsiu.dominio.modelos.Colaborador;
import lombok.Data;

import javax.swing.*;

@Data
@Entity
@Table(name = "colaborador")
public class ColaboradorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
    private String senha;
	private String hierarquia;
	private String score;
	private String complexidade;
    private Integer idPai;

    public ColaboradorEntity() {
    }

    public ColaboradorEntity(Colaborador colaborador) {
        this.nome = colaborador.getNome();
        this.senha = colaborador.getSenha();
        this.hierarquia = colaborador.getHierarquia();
        this.score = colaborador.getScore();
        this.complexidade = colaborador.getComplexidade();
        this.idPai = colaborador.getIdPai();
    }
    
    public void atualizar(Colaborador colaborador) {
        this.id = colaborador.getId();
        this.nome = colaborador.getNome();
        this.senha = colaborador.getSenha();
        this.hierarquia = colaborador.getHierarquia();
        this.score = colaborador.getScore();
        this.complexidade = colaborador.getComplexidade();
        this.idPai = colaborador.getIdPai();
    }    

    public Colaborador toColaborador() {
        return new Colaborador(this.id, this.nome, this.senha, this.hierarquia, this.score, this.complexidade, this.idPai);
    }
}
