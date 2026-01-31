package com.project.readydish.model.mappers;

import com.project.readydish.model.entities.Lunchbox;
import com.project.readydish.model.records.LunchboxRequest;
import com.project.readydish.model.records.LunchboxResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LunchboxMapper {

    Lunchbox toEntity(LunchboxRequest request);
    LunchboxResponse toResponse(Lunchbox lunchbox);
    List<LunchboxResponse> toListResponse(List<Lunchbox> lunchboxes);

    // Pega os dados do 'request' e joga dentro do 'lunchbox' existente
    void updateFromRequestToEntity(LunchboxRequest request, @MappingTarget Lunchbox lunchbox);
}
