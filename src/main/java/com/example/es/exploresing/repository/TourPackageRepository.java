package com.example.es.exploresing.repository;

import com.example.es.exploresing.entity.TourPackage;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TourPackageRepository extends CrudRepository<TourPackage,String> {
    Optional<TourPackage> findByName(String packageName);
}
