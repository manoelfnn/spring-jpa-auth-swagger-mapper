package com.example.springjpanew.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springjpanew.dtos.ClienteDto;
import com.example.springjpanew.dtos.mappers.ClienteMapper;
import com.example.springjpanew.entities.Cliente;
import com.example.springjpanew.entities.Ordem;
import com.example.springjpanew.repositories.ClienteRepository;
import com.example.springjpanew.repositories.OrdemRepository;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;
	private ClienteMapper clienteMapper;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
		this.clienteMapper = new ClienteMapper();
	}

	public Cliente criar(ClienteDto clienteDto) { 
		Cliente cliente = clienteMapper.toCliente(clienteDto);
		return clienteRepository.save(cliente);
	}

	public List<ClienteDto> listar() {
		List<Cliente> clientes = clienteRepository.findAll();
		ClienteMapper clienteMapper = new ClienteMapper();
		return clienteMapper.toParkingDTOList(clientes); 
	}

	public Boolean remover(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (!cliente.isPresent()) {
			return false;
		}
		clienteRepository.delete(cliente.get());
		return true;
	}

	public Cliente atualizar(Long id, ClienteDto clienteDto) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (!cliente.isPresent()) {
			return null;
		}
		cliente.get().setNome(clienteDto.getNome());
		cliente.get().setTelefone(clienteDto.getTelefone());
		cliente.get().setEndereco(clienteDto.getEndereco());
		return clienteRepository.save(cliente.get());
	}

	public List<Ordem> listaOrdens(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (!cliente.isPresent()) {
			return null;
		}
		return cliente.get().getOrdens();
	}

}
