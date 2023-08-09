package com.example.ToDoList.ToDoList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/ToDo")
@CrossOrigin(origins = "*")
public class ToDoListController {
    
    

    private final ToDoListService toDoListService;

    @Autowired
    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping
    public List<ToDoList> getToDoListas(){
        return toDoListService.getToDoLists();
    }

    @PostMapping
    public ResponseEntity<Object> registrarTarea(@RequestBody ToDoList toDoList){
        return this.toDoListService.newName(toDoList);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarTarea(@RequestBody ToDoList toDoList ){
        return this.toDoListService.newName(toDoList);
    }

    @DeleteMapping(path = "{tareaId}")
    public ResponseEntity<Object> eliminarTarea( @PathVariable("tareaId") Long id){
        return this.toDoListService.deletetoDoList(id);
    }
}
