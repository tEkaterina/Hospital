package hospital.services;

import hospital.models.Analysis;
import hospital.repositories.concrete.Repository;

public class AnalyzService {

    public static void delete(int id){

        Repository<Analysis> analysisRepository = new Repository<Analysis>(Analysis.class);
        Analysis entity = analysisRepository.getById(id);
        analysisRepository.delete(entity);
        analysisRepository.close();
    }

    public static void create(Analysis entity) {
        Repository<Analysis> analysisRepository = new Repository<Analysis>(Analysis.class);
        analysisRepository.add(entity);
        analysisRepository.close();
    }

    public static Analysis getById(int id){
        Repository<Analysis> analysisRepository = new Repository<Analysis>(Analysis.class);
        Analysis entity = analysisRepository.getById(id);
        analysisRepository.close();
        return entity;
    }

    public static void update(Analysis entity) {
        Repository<Analysis> analysisRepository = new Repository<Analysis>(Analysis.class);
        analysisRepository.update(entity);
        analysisRepository.close();
    }
}
