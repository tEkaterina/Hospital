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

    private int hbA1c;
    private int totalCholesterol;
    private int triglycerides;

    @OneToMany
    @JoinColumn(name = "visit_id")
    private Set<Visit> visits;

    public Analysis(){
        visits = new HashSet<Visit>();
    }

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

    public int getHbA1c() {
        return hbA1c;
    }
    public void setHbA1c(int hbA1c) {
        this.hbA1c = hbA1c;
    }

    public int getTotalCholesterol() {
        return totalCholesterol;
    }
    public void setTotalCholesterol(int totalCholesterol) {
        this.totalCholesterol = totalCholesterol;
    }

    public int getTriglycerides() {
        return triglycerides;
    }
    public void setTriglycerides(int triglycerides) {
        this.triglycerides = triglycerides;
    }

    public Set<Visit> getVisits() {
        return visits;
    }
    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

}
