package br.unifor.service.treino.unitreino.Controller;

import br.unifor.service.treino.unitreino.Model.ModelTreino;
import br.unifor.service.treino.unitreino.Service.ServiceTreino;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/treinos")
public class ControllerTreino {

	private final ServiceTreino service;

	public ControllerTreino(ServiceTreino service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<ModelTreino>> listar() {
		List<ModelTreino> lista = service.getAllTreinos();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<ModelTreino> criar(@RequestBody ModelTreino novo) {
		ModelTreino criado = service.createTreino(novo);
		URI location = URI.create("/treinos/" + criado.getId());
		return ResponseEntity.created(location).body(criado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ModelTreino> atualizar(@PathVariable Long id, @RequestBody ModelTreino atualizacao) {
		return service.updateTreino(id, atualizacao)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		boolean removed = service.deleteTreino(id);
		if (removed) return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
}
