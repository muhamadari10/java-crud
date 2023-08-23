package belajarjava.todolist.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "todolist")
@NamedQuery(name="todo.getAllTodolist", query="select t from Todolist t")
public class Todolist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String todo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "Todolist{" +
                "id='" + id + '\'' +
                ", todo='" + todo + '\'' +
                '}';
    }
}
