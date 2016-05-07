package hospital.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "analyzes")
public class Analysis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private float hbA1c;
    private float totalCholesterol;
    private float triglycerides;

    @ManyToOne
    @JoinColumn(name = "visit_id")
    private Visit visit;

    public Analysis(){ }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public float getHbA1c() {
        return hbA1c;
    }
    public void setHbA1c(float hbA1c) {
        this.hbA1c = hbA1c;
    }

    public float getTotalCholesterol() {
        return totalCholesterol;
    }
    public void setTotalCholesterol(float totalCholesterol) {
        this.totalCholesterol = totalCholesterol;
    }

    public float getTriglycerides() {
        return triglycerides;
    }
    public void setTriglycerides(float triglycerides) {
        this.triglycerides = triglycerides;
    }

    public Visit getVisit() {
        return visit;
    }
    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}
