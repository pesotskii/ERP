package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "ROLE")
    //это пока заготовка - мы не разбирали как правильно в JPA делать внешние ключи, потом переделаю
    //@ManyToOne
    //@JoinColumn(foreignKey = @ForeignKey(name = "ROLE_ID"))
    private int role;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_name;

    @Column(name = "MANAGER")
    //предположительно нужно тоже сделать внешним ключом
    private int manager;

    @Column(name = "DEPARTMENT")
    //аналогично это должен быть внешний ключ
    private int department;

    @Column(name = "Status")
    private String status;

    @Column(name = "START_DATE")
    private Date start_date;

    @Column(name = "FINISH_DATE")
    private Date finish_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public User(){}
}
