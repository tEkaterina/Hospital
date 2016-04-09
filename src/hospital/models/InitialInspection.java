package hospital.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "initial_inspections")
public class InitialInspection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @ManyToOne
    @JoinColumn(name = "disease_type_id")
    private DiseaseType diseaseType;

    private byte height;
    private byte weight;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Patient patient;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public Date getRegistrationDate(){
        return registrationDate;
    }
    public void setRegistrationDate(Date registrationDate){
        this.registrationDate = registrationDate;
    }

    public DiseaseType getDiseaseType(){
        return diseaseType;
    }
    public void setDiseaseType(DiseaseType diseaseType){
        this.diseaseType = diseaseType;
    }

    public byte getHeight(){
        return height;
    }
    public void setHeight(byte height){
        this.height = height;
    }

    public byte getWeight(){
        return weight;
    }
    public void setWeight(byte weight){
        this.weight = weight;
    }

    public Doctor getDoctor(){
        return doctor;
    }
    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }
}
