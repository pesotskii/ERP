package erp.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "RES")
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "PROJECT")
    private Project project;

    @Column(name = "REQ_DATE")
    private Date req_date;

    @Column(name = "STATUS")
    private int status;//=0 -- pending request, =1 -- assigned, =2 -- declined, =3 -- finished

    @Column(name = "ASS_DATE")//if resource was assigned to project this field will contain date of assignment
    private Date ass_date;

    @Column(name = "EXP_DATE")
    private Date exp_date;//if resource has a date when it expires, this field will contain it

    @Column(name = "DESCRIPTION")
    private String description;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Date getReq_date() { return req_date; }

    public void setReq_date(Date req_date) { this.req_date = req_date; }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }

    public Date getAss_date() { return ass_date; }

    public void setAss_date(Date ass_date) { this.ass_date = ass_date; }

    public Date getExp_date() { return exp_date; }

    public void setExp_date(Date exp_date) { this.exp_date = exp_date; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Project getProject() { return project; }

    public void setProject(Project project) { this.project = project; }

    public Resources() {}
}
