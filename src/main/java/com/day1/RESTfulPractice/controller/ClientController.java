package com.day1.RESTfulPractice.controller;

import com.day1.RESTfulPractice.application.service.ClientService;
import com.day1.RESTfulPractice.controller.dto.request.ClientRequest;
import com.day1.RESTfulPractice.controller.dto.response.ClientResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<ClientResponse> getAllClients(){
        log.info("Executing get all clients");
        return (List<ClientResponse>) clientService.getAllClients();
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@Validated @RequestBody ClientRequest clientRequest){
        log.info("Executing create a client with this parameters{}", clientRequest);
        ClientResponse clientResponse = clientService.createClient(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(clientRequest));
    }


}
