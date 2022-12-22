package com.example.demo.repositories;

import com.example.demo.model.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietaRepository extends JpaRepository<Dieta, Long> {
}

