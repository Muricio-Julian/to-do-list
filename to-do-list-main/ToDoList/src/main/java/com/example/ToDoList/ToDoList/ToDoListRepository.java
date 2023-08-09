package com.example.ToDoList.ToDoList;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

    Optional<ToDoList> findToDoListById(Long id);

    Optional<ToDoList> findToDoListByName(String name);
}
