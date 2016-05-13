package hospital.services;

import hospital.models.Doctor;
import hospital.models.User;
import hospital.repositories.concrete.Repository;

public class TempUserService {
    public static User getUser() {
        User user = new User();
        user.setRoleName(User.RoleName.Admin);
        user.setActivity(true);
        Repository<User> repository = new Repository<User>(User.class);
        repository.add(user);
        repository.close();

        //user.setRoleName(User.RoleName.Doctor);
        //user.setDoctor(DoctorService.getById(1));
        return user;
    }
}
