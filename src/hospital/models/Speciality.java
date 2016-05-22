package hospital.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialities")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL)
    private Set<Doctor> doctors;

    public Speciality(){
        doctors = new HashSet<Doctor>();
    }
    public Speciality(String name){
        doctors = new HashSet<Doctor>();
        this.name = name;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Set getDoctors(){
        return doctors;
    }
    public void setDoctors(Set doctors){
        this.doctors = doctors;
    }
}
