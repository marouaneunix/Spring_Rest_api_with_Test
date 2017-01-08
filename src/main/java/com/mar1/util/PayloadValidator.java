package com.mar1.util;

import com.mar1.model.ToDo;

public class PayloadValidator {
	
	public static boolean validateCreatePayload(ToDo toDo){
		if (toDo.getId() > 0){
			return false;
		}
		return true;
	}

}
