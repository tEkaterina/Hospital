package hospital.models;

import org.hibernate.annotations.GenericGenerator;

import org.hibernate.annotations.Parameter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor {

    public enum Category { Первая, Вторая, Высшая }

    @Id
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign",
            parameters=@Parameter(name="property", value="user"))
    private int id;

    private String surname;
    private String name;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    private Category category;
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<Visit> visits;

    public Doctor(){
        visits = new HashSet<Visit>();
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Speciality getSpeciality(){
        return speciality;
    }
    public void setSpeciality(Speciality speciality){
        this.speciality = speciality;
    }

    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category = category;
    }

    public String getTelephone(){
        return telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    public Set<Visit> getVisits(){
        return visits;
    }
    public void setVisits(Set<Visit> visits){
        this.visits = visits;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
