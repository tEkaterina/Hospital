package hospital.models;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    public enum RoleName { Admin, Doctor }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email;
    private String password;
    private String salt;

    private RoleName roleName;
    
    @OneToOne(mappedBy="user", cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Doctor doctor;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public RoleName getRoleName() {
        return roleName;
    }
    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public boolean isAdmin() {
        return roleName == RoleName.Admin;
    }

    public boolean isDoctor() {
        return roleName == RoleName.Doctor;
    }
}
