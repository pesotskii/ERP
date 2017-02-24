package entities;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    //не уверен о том какое название лучше использовать, опять же это должно быть внешним ключом к таблице USER
    @Column(name = "HEAD")
    private int head;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public Department() {}
}
