package belajarjava.todolist.service;

import belajarjava.todolist.entity.Todolist;
import belajarjava.todolist.repository.TodolistRepository;
import belajarjava.todolist.repository.TodolistRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TodolistServiceImpl implements TodolistService{

    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Autowired
    private TodolistService todolistService;

    @Override
    public void showTodolist() {
        TodolistRepositoryImpl repository = new TodolistRepositoryImpl();
        List<Todolist> todolist = repository.findAll();

        todolist.forEach(t -> System.out.println("id " + t.getId() + ":" + t.getTodo()));
    }

    @Override
    public void addTodolist(String todo) {
        TodolistRepositoryImpl repository = new TodolistRepositoryImpl();
        repository.addTodo(todo);
    }

    @Override
    public void removeTodolist(Integer id) {
        TodolistRepositoryImpl repository = new TodolistRepositoryImpl();
        repository.removeTodo(id);
        showTodolist();
    }

    @Override
    public void updateTodo(Integer id, String todo) {
        TodolistRepositoryImpl repository = new TodolistRepositoryImpl();
        TodolistServiceImpl service = new TodolistServiceImpl(repository);
        service.showTodolist();
        repository.updateTodo(id, todo);

        service.showTodolist();
    }
}
