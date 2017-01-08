package com.mar1.service;



import java.util.List;

import com.mar1.model.ToDo;


public interface ToDoService {
	
	public List<ToDo> getAllToDo();
	public ToDo getToDoById(long id);
	public ToDo saveTodo(ToDo todo);
	public void removeToDo(ToDo todo);

}
