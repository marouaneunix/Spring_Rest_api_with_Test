package com.mar1.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mar1.model.ToDo;
import com.mar1.repository.ToDoRepository;




@Service("toDoService")
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;
	
	
	@Override
	public List<ToDo> getAllToDo() {
		// TODO Auto-generated method stub
		
		return toDoRepository.findAll();
	}

	@Override
	public ToDo getToDoById(long id) {
		// TODO Auto-generated method stub
		return toDoRepository.findOne(id);
	}

	@Override
	public ToDo saveTodo(ToDo todo) {
		// TODO Auto-generated method stub
		return toDoRepository.save(todo);
	}

	@Override
	public void removeToDo(ToDo todo) {
		// TODO Auto-generated method stub
		toDoRepository.delete(todo);
	}

}
