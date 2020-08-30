package com.task;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

	public static List<Task> dao = new ArrayList<>();
	static {
		dao.add(new Task(1, "new", "this my first new task"));
		dao.add(new Task(2, "new", "this is my second new task"));
		dao.add(new Task(2, "old", "my remaning task"));
	}
	
	public static List<Task> getAll() {
		return dao;
	}
	
	public static Task get(int id) {
		Task o = new Task(id);
		int index = dao.indexOf(o);
		if(index >= 0) {
			return dao.get(index);
		} else {
			return null;
		}
	}
	
	public static int add(Task task) {
		int newId = dao.size() + 1;
		task.setId(newId);
		dao.add(task);
		return newId;
	}
	
	public static boolean update(Task o) {
		int index = dao.indexOf(o);
		if(index >= 0) {
			dao.set(index, o);
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean delete(int id) {
		Task o = new Task(id);
		int index = dao.indexOf(o);
		if(index >= 0) {
			dao.remove(index);
			return true;
		} else {
			return false;
		}
	}
}
