package belajarjava.todolist.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todolist")
@NamedQuery(name="todo.getAllTodolist", query="select t from Todolist t")
public class Todolist {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    private String todo;

    @Override
    public String toString() {
        return "Todolist{" +
                "id='" + id + '\'' +
                ", todo='" + todo + '\'' +
                '}';
    }
}
