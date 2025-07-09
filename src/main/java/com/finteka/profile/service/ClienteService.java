package com.finteka.profile.service;

import com.finteka.profile.infrastructure.persistence.models.ClienteEntity;
import com.finteka.profile.infrastructure.persistence.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteEntity> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}

