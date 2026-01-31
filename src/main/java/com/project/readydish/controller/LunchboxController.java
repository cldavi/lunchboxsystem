package com.project.readydish.controller;

import com.project.readydish.model.records.LunchboxRequest;
import com.project.readydish.model.records.LunchboxResponse;
import com.project.readydish.model.services.LunchboxService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lunchbox")
@CrossOrigin(origins = "*")
public class LunchboxController {

    private final LunchboxService service;

    public LunchboxController(LunchboxService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<LunchboxResponse> post(@RequestBody @Valid LunchboxRequest lunchbox) {
        LunchboxResponse response = service.save(lunchbox);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<LunchboxResponse>> getAll() {
        List<LunchboxResponse> response = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/readById/{id}")
    public ResponseEntity<LunchboxResponse> getById(@PathVariable @Valid String id) {
        LunchboxResponse response = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody @Valid LunchboxRequest request) {
        LunchboxResponse response = service.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body("O item " + response.name() + " foi alterado");
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("O item foi deletado");
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        service.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Todos os itens foram deletados");
    }
}
