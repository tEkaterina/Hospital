package hospital.services;

import hospital.models.Analysis;
import hospital.models.Patient;
import hospital.models.Visit;
import hospital.repositories.concrete.Repository;

import java.util.Set;

public class VisitService {

    public static void delete(int id){
        Repository<Visit> visitRepository = new Repository<Visit>(Visit.class);
        Visit entity = visitRepository.getById(id);
        visitRepository.delete(entity);
        visitRepository.close();
    }

    public static Visit getById(int id){
        Repository<Visit> visitRepository = new Repository<Visit>(Visit.class);
        Visit entity = visitRepository.getById(id);
        visitRepository.close();
        return entity;
    }

    public static void update(int id, String comment){
        Repository<Visit> visitRepository = new Repository<Visit>(Visit.class);
        Visit entity = visitRepository.getById(id);
        entity.setComment(comment);
        visitRepository.update(entity);
        visitRepository.close();
    }

    public static void create(Visit entity){
        Repository<Visit> visitRepository = new Repository<Visit>(Visit.class);
       visitRepository.add(entity);
        visitRepository.close();
    }

    public static Set<Analysis> getAnalyzes(int id) {

        Repository<Visit> visitRepository = new Repository<Visit>(Visit.class);
        Set<Analysis> analyzes = visitRepository.getById(id).getAnalyzes();
        return analyzes;
    }
}
