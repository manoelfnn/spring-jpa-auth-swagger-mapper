package com.example.springjpanew.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpanew.dtos.OrdemDto;
import com.example.springjpanew.entities.Ordem;
import com.example.springjpanew.entities.OrdemItem;
import com.example.springjpanew.services.OrdemService;

@RestController
@RequestMapping("/ordens")
public class OrdemController {

	@Autowired
	private OrdemService ordemService;

	@PostMapping
	public OrdemDto criar(@Valid @RequestBody OrdemDto ordemDto) {
		ordemService.criar(ordemDto);
		return ordemDto;
	}

	@GetMapping
	public List<Ordem> listar() {
		return ordemService.listar();
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		ordemService.remover(id);
	}

	@GetMapping("/{id}/items")
	public List<OrdemItem> listaItens(@PathVariable Long id) {
		return ordemService.listaItens(id);
	}

}
