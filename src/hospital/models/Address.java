package hospital.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String street;
    private String house;
    private String housing; //корпус
    private String apartment;

    @OneToMany(mappedBy = "address")
    private Set<Patient> patients;

    public Address(){
        patients = new HashSet<Patient>();
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getStreet(){
        return street;
    }
    public void setStreet(String street){
        this.street = street;
    }

    public String getHouse(){
        return house;
    }
    public void setHouse(String house){
        this.house = house;
    }

    public String getHousing(){
        return housing;
    }
    public void setHousing(String housing){
        this.housing = housing;
    }

    public String getApartment(){
        return apartment;
    }
    public void setApartment(String apartment){
        this.apartment = apartment;
    }

    public Set<Patient> getPatients(){
        return patients;
    }
    public void setPatients(Set<Patient> patients){
        this.patients = patients;
    }
}
