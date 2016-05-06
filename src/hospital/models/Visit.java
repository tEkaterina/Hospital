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

    public Visit(){ }

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

    public Analysis getAnalysis() {
        return analysis;
    }
    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

}
