package hospital.services;

import hospital.models.Speciality;
import hospital.repositories.concrete.Repository;

import java.util.List;

public class SpecialityService {

    public static Speciality getByName(String specialityName) {

        Repository<Speciality> specialityRepository = new Repository<Speciality>(Speciality.class);
        Speciality speciality = specialityRepository.getByField("name", specialityName);
        specialityRepository.close();
        return speciality;
    }

    public static List<Speciality> getAll() {
        Repository<Speciality> specialityRepository = new Repository<Speciality>(Speciality.class);
        List<Speciality> specialities = specialityRepository.getAll();
        specialityRepository.close();
        return specialities;
    }
}
