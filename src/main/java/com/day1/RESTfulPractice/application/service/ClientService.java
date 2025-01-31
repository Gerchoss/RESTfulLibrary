package com.day1.RESTfulPractice.application.service;

import com.day1.RESTfulPractice.controller.dto.ClientMapper;
import com.day1.RESTfulPractice.controller.dto.request.ClientRequest;
import com.day1.RESTfulPractice.controller.dto.response.ClientResponse;
import com.day1.RESTfulPractice.db.ClientRepository;
import com.day1.RESTfulPractice.db.entities.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    @Autowired
    private final ClientMapper clientMapper;

    @Autowired
    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<ClientResponse> getAllClients(){
        List<ClientEntity> clientEntity = clientRepository.findAll();
        return clientMapper.toResponseList(clientEntity);
    }

    @Transactional
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest){
        ClientEntity clientEntity = clientMapper.toEntity(clientRequest);
        ClientEntity savedEntity = clientRepository.save(clientEntity);
        return clientMapper.toResponse(savedEntity);
    }
    //faltan crear cliente y obtener un cliente
}
