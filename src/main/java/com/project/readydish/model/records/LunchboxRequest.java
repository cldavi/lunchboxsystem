package com.project.readydish.model.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record LunchboxRequest(
        @NotBlank @Size(max = 55) String name,
        @NotBlank String description,
        @NotNull @Positive Double price
) {}
