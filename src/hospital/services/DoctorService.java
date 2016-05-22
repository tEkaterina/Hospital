package hospital.services;

import hospital.models.Doctor;
import hospital.models.Speciality;
import hospital.models.Visit;
import hospital.repositories.concrete.Repository;

import java.util.List;
import java.util.Set;

public class DoctorService {

    public static void update(Doctor entity){
        Repository<Doctor> DoctorRepository = new Repository<Doctor>(Doctor.class);
        DoctorRepository.update(entity);
        DoctorRepository.close();
    }

    public static void delete(int id){
        Repository<Doctor> doctorRepository = new Repository<Doctor>(Doctor.class);
        Doctor entity = doctorRepository.getById(id);
        doctorRepository.delete(entity);
        doctorRepository.close();
    }

    public static Doctor getById(int id){
        Repository<Doctor> doctorRepository = new Repository<Doctor>(Doctor.class);
        Doctor Doctor = doctorRepository.getById(id);
        doctorRepository.close();
        return Doctor;
    }

    public static List<Doctor> getAll() {
        Repository<Doctor> doctorRepository = new Repository<Doctor>(Doctor.class);
        List<Doctor> doctors = doctorRepository.getAll();
        doctorRepository.close();
        return doctors;
    }

    public static Set<Visit> getVisits(int id) {
        Repository<Doctor> DoctorRepository = new Repository<Doctor>(Doctor.class);
        Set<Visit> visits = DoctorRepository.getById(id).getVisits();
        //DoctorRepository.close();
        return visits;
    }

    public static void addDoctor(Doctor doctor){
        Repository<Doctor> doctorRepository = new Repository<Doctor>(Doctor.class);
        doctorRepository.add(doctor);
        doctorRepository.close();
    }

    public static void checkSpecialityList(){
        Repository<Speciality> specialityRepository = new Repository<Speciality>(Speciality.class);
        if (specialityRepository.getAll().isEmpty()){
            Speciality speciality = new Speciality("Терапевт");
            specialityRepository.add(speciality);

            speciality = new Speciality("Хирург");
            specialityRepository.add(speciality);

            speciality = new Speciality("Эндокринолог");
            specialityRepository.add(speciality);
        }
    }
}
