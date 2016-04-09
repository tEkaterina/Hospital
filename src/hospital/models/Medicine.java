package hospital.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private double dailyDose;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "release_dosage_form_id")
    private ReleaseDosageForm releaseDosageForm; //форма выпуска

    @ManyToOne
    @JoinColumn(name = "active_ingredient_id")
    private ActiveIngredient activeIngredient;

    @ManyToMany(cascade= CascadeType.ALL, mappedBy="medicines")
    private Set<Visit> visits;

    public Medicine(){
        visits = new HashSet<Visit>();
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

    public double getDailyDose(){
        return dailyDose;
    }
    public void setDailyDose(double dailyDose){
        this.dailyDose = dailyDose;
    }

    public Date getStartDate(){
        return startDate;
    }
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getEndDate(){
        return endDate;
    }
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public Set<Visit> getVisits(){
        return visits;
    }
    public void setVisits(Set<Visit> visits){
        this.visits = visits;
    }

    public ReleaseDosageForm getReleaseDosageForm() {
        return releaseDosageForm;
    }
    public void setReleaseDosageForm(ReleaseDosageForm releaseDosageForm) {
        this.releaseDosageForm = releaseDosageForm;
    }

    public ActiveIngredient getActiveIngredient() {
        return activeIngredient;
    }
    public void setActiveIngredient(ActiveIngredient activeIngredient) {
        this.activeIngredient = activeIngredient;
    }

}
