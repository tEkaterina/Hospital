package hospital.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "active_ingredients")
public class ActiveIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "activeIngredient")
    private Set<Medicine> medicines;

    public ActiveIngredient(){
        medicines = new HashSet<Medicine>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
}
