package hospital.models;

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

    public boolean isAdmin() {
        if (this.roleName == RoleName.Admin)
            return true;
        else
            return false;
    }

    public boolean isDoctor() {
        if (this.roleName == RoleName.Doctor)
            return true;
        else
            return false;
    }
}
