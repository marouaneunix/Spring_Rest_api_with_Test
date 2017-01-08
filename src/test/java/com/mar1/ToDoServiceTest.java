package com.mar1;


import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mar1.model.ToDo;
import com.mar1.repository.ToDoRepository;
import com.mar1.service.ToDoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ToDoServiceTest {
	
	@Mock
	private ToDoRepository toDoRepository;
	
	@InjectMocks
	private ToDoServiceImpl toDoService;
	
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllToDo(){
		List<ToDo> toDoList = new ArrayList<ToDo>();
		toDoList.add(new ToDo(1,"Todo Sample 1",true));
		toDoList.add(new ToDo(2,"Todo Sample 2",true));
		toDoList.add(new ToDo(3,"Todo Sample 3",false));
		when(toDoRepository.findAll()).thenReturn(toDoList);
	
		List<ToDo> result = toDoService.getAllToDo();
		assertEquals(3, result.size());
	}
	
	@Test
	public void testGetToDoById(){
		ToDo toDo = new ToDo(1,"Todo Sample 1",true);
		when(toDoRepository.findOne(1L)).thenReturn(toDo);
		ToDo result = toDoService.getToDoById(1);
		assertEquals(toDo.getId(), result.getId());
		assertEquals(toDo.getText(), result.getText());
		assertEquals(toDo.isCompleted(), result.isCompleted());
	}
	
	@Test
	public void saveToDo(){
		ToDo toDo = new ToDo("my ToDo", false);
		when(toDoRepository.save(toDo)).thenReturn(toDo);
		ToDo result = toDoService.saveTodo(toDo);
		assertEquals(toDo.getText(), result.getText());
		assertEquals(toDo.isCompleted(), result.isCompleted());
	}
	
	@Test
	public void removeToDo(){
		ToDo toDo = new ToDo(5,"my ToDo", false);
		toDoService.removeToDo(toDo);
		verify(toDoRepository, times(1)).delete(toDo);
	}
}
