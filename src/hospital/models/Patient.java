package hospital.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String surname;
    private String clinicNumber; //TODO

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Visit> visits;

    public Patient(){
        visits = new HashSet<Visit>();
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getClinicNumber() {
        return clinicNumber;
    }
    public void setClinicNumber(String clinicNumber){
        this.clinicNumber = clinicNumber;
    }

    public Address getAddress(){
        return address;
    }
    public void setAddress(Address address){
        this.address = address;
    }

    public Set<Visit> getVisits(){
        return visits;
    }
    public void setVisits(Set<Visit> visits){
        this.visits = visits;
    }
}
