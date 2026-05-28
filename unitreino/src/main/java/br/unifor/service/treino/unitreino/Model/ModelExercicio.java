package br.unifor.service.treino.unitreino.Model;

public class ModelExercicio {

    private Long id;
    private String nome;
    private Integer series;
    private Integer repeticoes;
    private Integer carga;
    private String observacao;

    public ModelExercicio() {
    }

    public ModelExercicio(Long id, String nome, Integer series, Integer repeticoes, Integer carga, String observacao) {
        this.id = id;
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
        this.carga = carga;
        this.observacao = observacao;
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

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    public Integer getCarga() {
        return carga;
    }

    public void setCarga(Integer carga) {
        this.carga = carga;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "ModelExercicio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", series=" + series +
                ", repeticoes=" + repeticoes +
                ", carga=" + carga +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
