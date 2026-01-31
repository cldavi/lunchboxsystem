package com.project.readydish.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.readydish.model.entities.Lunchbox;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchboxRepository extends JpaRepository<Lunchbox, String> {}
