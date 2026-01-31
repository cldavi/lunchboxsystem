package com.project.readydish.model.services;

import com.project.readydish.model.entities.Lunchbox;
import com.project.readydish.model.mappers.LunchboxMapper;
import com.project.readydish.model.records.LunchboxRequest;
import com.project.readydish.model.records.LunchboxResponse;
import com.project.readydish.model.repositories.LunchboxRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LunchboxService {

    private final LunchboxRepository repository;
    private final LunchboxMapper mapper;

    public LunchboxService(LunchboxRepository repository, LunchboxMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public LunchboxResponse save(LunchboxRequest request) {
        Lunchbox lunchbox = mapper.toEntity(request);
        lunchbox = repository.save(lunchbox);
        return mapper.toResponse(lunchbox);
    }

    public List<LunchboxResponse> findAll() {
        List<Lunchbox> lunchboxes = repository.findAll();
        return mapper.toListResponse(lunchboxes);
//        return lunchboxes.stream().map(LunchboxResponse::new).toList();
    }

    public LunchboxResponse findById(String id) {
        Lunchbox lunchbox = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Marmita não encontrada")
        );
        return mapper.toResponse(lunchbox);
    }

    public LunchboxResponse update(String id, LunchboxRequest request) {
        Lunchbox lunchbox = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Marmita não encontrada")
        );
        mapper.updateFromRequestToEntity(request, lunchbox);
        lunchbox = repository.save(lunchbox);
        return mapper.toResponse(lunchbox);
    }

    public void deleteById(String id) {
        Lunchbox lunchbox = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Marmita com identificador '" + id + "' não encontrada")
        );
        repository.delete(lunchbox);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
