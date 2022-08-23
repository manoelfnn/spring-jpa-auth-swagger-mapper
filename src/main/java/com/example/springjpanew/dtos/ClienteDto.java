package com.example.springjpanew.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.springjpanew.entities.Cliente;

public class ClienteDto {
	
	@NotEmpty (message = "Preencha o campo corretamente.")
	@Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String nome;
	@NotEmpty (message = "Preencha o campo corretamente.")
	private String telefone;
	@NotEmpty (message = "Preencha o campo corretamente.")
	private String endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
