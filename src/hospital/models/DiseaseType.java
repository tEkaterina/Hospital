package hospital.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disease_types")
public class DiseaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "diseaseType")
    private Set<InitialInspection> initialInspections;

    public DiseaseType(){
        initialInspections = new HashSet<InitialInspection>();
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

    public Set<InitialInspection> getIntialInspections(){
        return initialInspections;
    }
    public void setIntialInspections(Set<InitialInspection> initialInspections){
        this.initialInspections = initialInspections;
    }
}
