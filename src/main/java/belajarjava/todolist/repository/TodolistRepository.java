package belajarjava.todolist.repository;

import belajarjava.todolist.entity.Todolist;

import java.util.List;

public interface TodolistRepository {
    List<Todolist> findAll();

    void addTodo(String todo);

    void removeTodo(Integer id);

    void updateTodo(Integer id, String todo);
}
