package com.example.agenda.Controller;

import com.example.agenda.model.Tarea;
import com.example.agenda.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = tareaService.crearTarea(tarea);
        return ResponseEntity.ok(nuevaTarea);
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> obtenerTareas() {
        List<Tarea> tareas = tareaService.obtenerTareas();
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id) {
        Optional<Tarea> tarea = tareaService.obtenerTareaPorId(id);
        if (tarea.isPresent()) {
            return ResponseEntity.ok(tarea.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tarea, Object ResponseEntity) {
        Optional<Tarea> tareaExistente = tareaService.obtenerTareaPorId(id);
        if (tareaExistente.isPresent()) {
            tarea.setId(id);
            Tarea tareaActualizada = tareaService.actualizarTarea(tarea);
            return ResponseEntity.ok(tareaActualizada);
        } else {
            return ResponseEntity.notify().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        Optional<Tarea> tarea = tareaService.obtenerTareaPorId(id);
        if (tarea.isPresent()) {
            tareaService.eliminarTarea(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
