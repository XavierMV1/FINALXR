package com.example.agenda.repository;

import com.example.agenda.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    void deleteById(Long id);

    Tarea save(Tarea tarea);

    Optional<Tarea> findById(Long id);

    List<Tarea> findAll();
}
