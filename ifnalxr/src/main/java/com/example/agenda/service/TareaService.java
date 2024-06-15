package com.example.agenda.service;

import com.example.agenda.model.Tarea;
import com.example.agenda.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public List<Tarea> obtenerTareas() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public Tarea actualizarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}
