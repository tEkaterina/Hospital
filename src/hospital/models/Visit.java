package hospital.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "analysis_id")
    private Analysis analysis;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="visit_to_medicine",
            joinColumns = { @JoinColumn(name="visit_id") },
            inverseJoinColumns = { @JoinColumn(name="medicine_id")})
    private Set<Medicine> medicines;

    public Visit(){
        medicines = new HashSet<Medicine>();
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }

    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }

    public Doctor getDoctor(){
        return doctor;
    }
    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public Patient getPatient(){
        return patient;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public Set<Medicine> getMedicines(){
        return medicines;
    }
    public void setMedicines(Set<Medicine> medicines){
        this.medicines = medicines;
    }

    public Analysis getAnalysis() {
        return analysis;
    }
    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

}
