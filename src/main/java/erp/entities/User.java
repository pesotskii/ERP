package erp.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ROLE")
    private Role role;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_name;

    @ManyToOne
    @JoinColumn(name = "MANAGER")
    private User manager;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT")
    private Department department;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "HIRE_DATE")
    private Date hire_date;

    @Column(name = "FIRE_DATE")
    private Date fire_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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

    public void setLast_name(String last_name) { this.last_name = last_name; }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Date getHire_date() { return hire_date; }

    public void setHire_date(Date hire_date) { this.hire_date = hire_date; }

    public Date getFire_date() { return fire_date; }

    public void setFire_date(Date fire_date) { this.fire_date = fire_date; }

    public User(){}
}
