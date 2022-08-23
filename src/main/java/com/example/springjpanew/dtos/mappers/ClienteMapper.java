package com.example.springjpanew.dtos.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.springjpanew.dtos.ClienteDto;
import com.example.springjpanew.entities.Cliente;

@Component
public class ClienteMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ClienteDto toClienteDTO(Cliente cliente) {
        return MODEL_MAPPER.map(cliente, ClienteDto.class);
    }

    public List<ClienteDto> toParkingDTOList(List<Cliente> clienteList) {
        return clienteList.stream().map(this::toClienteDTO).collect(Collectors.toList());
    }

    public Cliente toCliente(ClienteDto dto) {
        return MODEL_MAPPER.map(dto, Cliente.class);
    }

    public Cliente toClienteCreate(ClienteDto dto) {
        return MODEL_MAPPER.map(dto, Cliente.class);
    }
}