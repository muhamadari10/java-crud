package belajarjava.todolist.service;

import belajarjava.todolist.entity.Todolist;

import java.util.List;

public interface TodolistService {

    void showTodolist();

    void addTodolist(String todo);

    void removeTodolist(Integer id);

    void updateTodo(Integer id, String todo);

}
