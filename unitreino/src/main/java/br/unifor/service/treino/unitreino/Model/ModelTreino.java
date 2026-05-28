package br.unifor.service.treino.unitreino.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelTreino {

	private Long id;

	private String nome;

	private String descricao;

	private Integer duracaoMinutos;

	private List<ModelExercicio> exercicios = new ArrayList<>();

	public ModelTreino() {
	}

	public ModelTreino(Long id, String nome, String descricao, Integer duracaoMinutos) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.duracaoMinutos = duracaoMinutos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getDuracaoMinutos() {
		return duracaoMinutos;
	}

	public void setDuracaoMinutos(Integer duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}

	public List<ModelExercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<ModelExercicio> exercicios) {
		this.exercicios = exercicios != null ? exercicios : new ArrayList<>();
	}

	@Override
	public String toString() {
		return "ModelTreino{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", descricao='" + descricao + '\'' +
				", duracaoMinutos=" + duracaoMinutos +
				'}';
	}
}
