package com.example.es.exploresing.service;

import com.example.es.exploresing.entity.Tour;
import com.example.es.exploresing.entity.TourPackage;
import com.example.es.exploresing.repository.TourPackageRepository;
import org.hibernate.collection.internal.PersistentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a Tour Package
     *
     * @param code code of the package
     * @param name name of the package
     *
     * @return new or existing tour package
     */
    public TourPackage createTourPackage(String code, String name) {

        return tourPackageRepository.findById(code)
                .orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    public void createTourPackages(List<TourPackage> tourPackages){
        for(TourPackage t:tourPackages) {
            tourPackageRepository.save(t);
        }
    }
    /**
     * Lookup All Tour packages
     *
     * @return all tour packages
     */
    public Iterable<TourPackage> lookup(){
        return tourPackageRepository.findAll();
    }
    /**
     * count total no of Tour packages
     *
     * @return no. of tour packages
     */
    public long total() {
        return tourPackageRepository.count();
    }


    public List<TourPackage> getAllTourPackages()
    {
        List<TourPackage> tourPackageList=new ArrayList<>();
        for(TourPackage t: tourPackageRepository.findAll())
            tourPackageList.add(t);
        return tourPackageList;
    }

    public TourPackage getTourPackageByCode(String code)
    {
        return tourPackageRepository.findById(code)
                .orElseThrow(()->new RuntimeException("tour package with code "+code+" not found.."));
    }

    public void deleteTourPackage(String code){
         tourPackageRepository.deleteById(code);
    }

    public TourPackage modifyTourPackage(TourPackage tourPackage){
        if(tourPackageRepository.existsById(tourPackage.getCode())){
            tourPackageRepository.deleteById(tourPackage.getCode());
            TourPackage newTourPackage= new TourPackage(tourPackage.getCode(),
                                            tourPackage.getName());
            tourPackageRepository.save(tourPackage);
            return newTourPackage;
        }
        else
            return new TourPackage(null,null);
    }

}