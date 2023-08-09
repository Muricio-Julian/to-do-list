package com.example.ToDoList.ToDoList;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

    HashMap<String, Object> datos;

    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoList> getToDoLists() {
        return this.toDoListRepository.findAll();
    }

    public void newTarea(ToDoList toDoList) {
        if (toDoList.getId() != null) {
            Optional<ToDoList> res = toDoListRepository.findById(toDoList.getId());
            if (res.isPresent()) {
                throw new IllegalStateException("Existe ya una tarea con ese id");
            }
        }

        toDoListRepository.save(toDoList);
    }

    public ResponseEntity<Object> newName(ToDoList toDoList) {
        Optional<ToDoList> res = toDoListRepository.findToDoListByName(toDoList.getname());
        datos = new HashMap<>();

        if (res.isPresent() && toDoList.getId() == null) {
            datos.put("Error", true);
            datos.put("Message", "Ya existe una tarea con este nombre");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        datos.put("Message", "Se guardo con exito");
        if (toDoList.getId() != null) {
            datos.put("Message", "Se actualizo con exito");
        }
        toDoListRepository.save(toDoList);
        datos.put("data", toDoList); // Corregir para agregar la reserva, no el mapa datos

        return new ResponseEntity<>(datos, HttpStatus.CREATED);

    }

    public ResponseEntity<Object> deletetoDoList(Long id) {
        datos = new HashMap<>();
        boolean existe = this.toDoListRepository.existsById(id);
        if (!existe) {
            datos.put("Error", true);
            datos.put("Message", "No existe una tarea con este ID");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);

        }
        toDoListRepository.deleteById(id);
            datos.put("Message", "tarea eliminada");
            return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }

}
