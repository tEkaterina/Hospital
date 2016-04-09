package hospital.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="release_dosage_forms")
public class ReleaseDosageForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy="releaseDosageForm")
    private Set<Medicine> medicines;

    public ReleaseDosageForm(){
        medicines = new HashSet<Medicine>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }
    public void setMedicines(Set<Medicine> medicines) {
        this.medicines = medicines;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
