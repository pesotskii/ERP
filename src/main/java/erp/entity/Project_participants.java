package erp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROJECT_PARTICIPANTS")
public class Project_participants {

    @ManyToOne
    @JoinColumn(name = "PROJECT")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "USER")
    private User user;

    @Column(name = "START_DATE")
    private Date start_date;

    @Column(name = "FINISH_DATE")
    private Date finish_date;

    @Column(name = "PROJECT_ROLE")
    private String p_role;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) { this.user = user; }

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

    public String getP_role() {
        return p_role;
    }

    public void setP_role(String role) {
        this.p_role = role;
    }

    public Project_participants() {}
}
