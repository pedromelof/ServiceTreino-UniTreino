package br.unifor.service.treino.unitreino.Repository;

import br.unifor.service.treino.unitreino.Model.ModelTreino;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class RepositoryTreino {

	private final Map<Long, ModelTreino> store = new ConcurrentHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong(1);

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

	public void deleteById(Long id) {
		store.remove(id);
	}
}
