package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Alexandr Zhilkin on 15.02.2017.
 */
@Entity
@Table(name = "PROJECT_PARTICIPANTS")
public class Project_participants {

    //должно быть внешним ключом к Project
    @Column(name = "PROJECT_ID")
    private int project_id;

    //должно быть внешним ключом к User
    @Column(name = "USER_ID")
    private int user_id;

    @Column(name = "START_DATE")
    private Date start_date;

    @Column(name = "FINISH_DATE")
    private Date finish_date;

    @Column(name = "ROLE")
    private String role;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Project_participants() {
    }
}
