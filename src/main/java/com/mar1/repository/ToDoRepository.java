package com.mar1.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mar1.model.ToDo;



@Repository("toDoRepository")
public interface ToDoRepository extends JpaRepository<ToDo, Long>{

}
