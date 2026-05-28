package br.unifor.service.treino.unitreino.Service;

import br.unifor.service.treino.unitreino.Model.ModelExercicio;
import br.unifor.service.treino.unitreino.Model.ModelTreino;
import br.unifor.service.treino.unitreino.Repository.RepositoryTreino;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTreino {

    private final RepositoryTreino repository;

    public ServiceTreino(RepositoryTreino repository) {
        this.repository = repository;
    }

    public ModelTreino createTreino(ModelTreino treino) {
        return repository.save(treino);
    }

    public List<ModelTreino> getAllTreinos() {
        return repository.findAll();
    }

    public java.util.Optional<ModelTreino> getTreinoById(Long id) {
        return repository.findById(id);
    }

    public java.util.Optional<ModelTreino> updateTreino(Long id, ModelTreino novo) {
        return repository.findById(id).map(existing -> {
            existing.setNome(novo.getNome());
            existing.setDescricao(novo.getDescricao());
            existing.setDuracaoMinutos(novo.getDuracaoMinutos());
            return repository.save(existing);
        });
    }

    public boolean deleteTreino(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public ModelExercicio addExercicioAoTreino(Long treinoId, ModelExercicio exercicio) {
        return repository.addExercicio(treinoId, exercicio);
    }

    public List<ModelExercicio> getExerciciosDoTreino(Long treinoId) {
        return repository.findExerciciosByTreinoId(treinoId);
    }

    public boolean removerExercicioDoTreino(Long treinoId, Long exercicioId) {
        return repository.removeExercicio(treinoId, exercicioId);
    }
}
