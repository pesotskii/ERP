package erp.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROJECT")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "MANAGER")
    private User manager;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAUNCH_DATE")
    private Date launch_date;

    @Column(name = "FINISH_DATE")
    private Date finish_date;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "COMMENT")
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User user) {
        this.manager = user;
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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Project() {}
}
