package br.unifor.service.treino.unitreino.Repository;

import br.unifor.service.treino.unitreino.Model.ModelTreino;
import org.springframework.stereotype.Repository;

import br.unifor.service.treino.unitreino.Model.ModelExercicio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class RepositoryTreino {

	private final Map<Long, ModelTreino> store = new ConcurrentHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong(1);
	private final AtomicLong exercicioIdGenerator = new AtomicLong(1);

	public ModelTreino save(ModelTreino treino) {
		if (treino.getId() == null) {
			treino.setId(idGenerator.getAndIncrement());
		}
		store.put(treino.getId(), treino);
		return treino;
	}

	public List<ModelTreino> findAll() {
		Collection<ModelTreino> values = store.values();
		return new ArrayList<>(values);
	}

	public Optional<ModelTreino> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	public ModelExercicio addExercicio(Long treinoId, ModelExercicio exercicio) {
		ModelTreino treino = findById(treinoId).orElseThrow(() -> new IllegalArgumentException("Treino não encontrado"));
		if (exercicio.getId() == null) {
			exercicio.setId(exercicioIdGenerator.getAndIncrement());
		}
		if (treino.getExercicios() == null) {
			treino.setExercicios(new ArrayList<>());
		}
		treino.getExercicios().add(exercicio);
		store.put(treino.getId(), treino);
		return exercicio;
	}

	public List<ModelExercicio> findExerciciosByTreinoId(Long treinoId) {
		return findById(treinoId)
				.map(ModelTreino::getExercicios)
				.orElse(Collections.emptyList());
	}

	public boolean removeExercicio(Long treinoId, Long exercicioId) {
		Optional<ModelTreino> treinoOptional = findById(treinoId);
		if (treinoOptional.isEmpty()) {
			return false;
		}

		ModelTreino treino = treinoOptional.get();
		boolean removed = treino.getExercicios().removeIf(exercicio -> exercicio.getId().equals(exercicioId));
		if (removed) {
			store.put(treino.getId(), treino);
		}
		return removed;
	}

	public void deleteById(Long id) {
		store.remove(id);
	}
}
