package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROJECT")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    //должно быть внешним ключом к User
    @Column(name = "MANAGER")
    private int manager;

    @Column(name = "LAUNCH_DATE")
    private Date launch_date;

    @Column(name = "FINISH_DATE")
    private Date finish_date;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "COMMENT")
    private String comment;
/*
/предлагаю хранить информацию о ресурсах, затраченных на проект, возможно стоит завести отдельную таблицу для этого?
    @Column
    private String resources;

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }
*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public Date getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(Date launch_date) {
        this.launch_date = launch_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Project() {
    }
}
