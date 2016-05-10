package hospital.services;

import hospital.models.Doctor;
import hospital.models.User;

public class TempUserService {
    public static User getUser() {
        User user = new User();
        //user.setRoleName(User.RoleName.Admin);
        user.setRoleName(User.RoleName.Doctor);
        user.setDoctor(DoctorService.getById(1));
        return user;
    }
}
