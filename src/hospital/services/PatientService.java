package hospital.services;

import hospital.models.Address;
import hospital.models.Patient;
import hospital.models.Visit;
import hospital.repositories.concrete.Repository;


import java.util.List;
import java.util.Set;

public class PatientService {

    public static void create(Patient entity) {
        Repository<Address> addressRepository = new Repository<Address>(Address.class);
        addressRepository.add(entity.getAddress());
        addressRepository.close();
        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);
        patientRepository.add(entity);
        patientRepository.close();
    }

    public static void update(Patient entity){
        Repository<Address> addressRepository = new Repository<Address>(Address.class);
        addressRepository.update(entity.getAddress());
        addressRepository.close();
        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);
        patientRepository.update(entity);
        patientRepository.close();
    }

    public static void delete(int id){
        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);
        Patient entity = PatientService.getById(id);
        patientRepository.delete(entity);
        patientRepository.close();
    }

    public static Patient getById(int id){
        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);
        Patient patient = patientRepository.getById(id);
        patientRepository.close();
        return patient;
    }

    public static List<Patient> getAll() {
        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);
        List<Patient> patients = patientRepository.getAll();
        patientRepository.close();
        return patients;
    }

    public static Set<Visit> getVisits(int id) {
        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);
        Set<Visit> visits = patientRepository.getById(id).getVisits();
        //patientRepository.close();
        return visits;
    }


}
