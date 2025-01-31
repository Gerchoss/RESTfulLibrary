package com.day1.RESTfulPractice.controller.dto;

import com.day1.RESTfulPractice.controller.dto.request.ClientRequest;
import com.day1.RESTfulPractice.controller.dto.response.ClientResponse;
import com.day1.RESTfulPractice.db.entities.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {
    public ClientEntity toEntity(ClientRequest clientRequest){
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientName(clientRequest.getClientName());
        clientEntity.setPassword(clientRequest.getPassword());
        clientEntity.setEmail(clientRequest.getEmail());
        return clientEntity;
    }

    public ClientResponse toResponse(ClientEntity clientEntity){
        if (clientEntity == null){
            return null;
        }
        return ClientResponse.builder()
                .clientName(clientEntity.getClientName())
                .email(clientEntity.getEmail())
                .build();
    }

    public List<ClientResponse> toResponseList(List<ClientEntity> clientEntity){
        return clientEntity.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public static ClientResponse findClientById(ClientEntity clientEntity){
        return ClientResponse.builder()
                .id(clientEntity.getId())
                .clientName(clientEntity.getClientName())
                .build();
    }
}
