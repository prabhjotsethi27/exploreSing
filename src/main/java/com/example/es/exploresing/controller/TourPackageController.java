package com.example.es.exploresing.controller;

import com.example.es.exploresing.entity.TourPackage;
import com.example.es.exploresing.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourPackages")
public class TourPackageController {

    @Autowired
    private TourPackageService tourPackageService;

    @GetMapping
    public List<TourPackage> getTourPackages()
    {
        return tourPackageService.getAllTourPackages();
    }

    @GetMapping("/{code}")
    public TourPackage getTourPackagesByCode(@PathVariable(value = "code") String code)
    {
        return tourPackageService.getTourPackageByCode(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourPackages(@RequestBody java.util.List<TourPackage> tourPackages){
        tourPackageService.createTourPackages(tourPackages);
    }

    @DeleteMapping("/{code}")
    public void deleteTourPackage(@PathVariable(value="code") String code){
        tourPackageService.deleteTourPackage(code);
    }

    @PutMapping
    public TourPackage modifyTourPackage(@RequestBody TourPackage tourPackage){
            return tourPackageService.modifyTourPackage(tourPackage);
    }

}
