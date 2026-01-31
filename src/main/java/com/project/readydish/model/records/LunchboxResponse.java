package com.project.readydish.model.records;

import com.project.readydish.model.entities.Lunchbox;

public record LunchboxResponse(
        String id,
        String name,
        String description,
        Double price
) {
    public LunchboxResponse(Lunchbox lunchbox) {
        this(lunchbox.getId(), lunchbox.getName(), lunchbox.getDescription(), lunchbox.getPrice());
    }
}
