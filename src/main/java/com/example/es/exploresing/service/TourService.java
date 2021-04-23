package com.example.es.exploresing.service;

import com.example.es.exploresing.entity.Difficulty;
import com.example.es.exploresing.entity.Region;
import com.example.es.exploresing.entity.Tour;
import com.example.es.exploresing.entity.TourPackage;
import com.example.es.exploresing.repository.TourPackageRepository;
import com.example.es.exploresing.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    private TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository){
        this.tourRepository=tourRepository;
        this.tourPackageRepository=tourPackageRepository;
    }

    /**
     * Create a new Tour Object and persist it to the Database.
     *
     * @param title title
     * @param description description
     * @param blurb blurb
     * @param price price
     * @param duration duration
     * @param bullets comma-separated bullets
     * @param keywords keywords
     * @param tourPackageName tour package name
     * @param difficulty difficulty
     * @param region region
     * @return Tour Entity
     */
    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region ) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(()->new RuntimeException("The Tour Package does not exist..."+tourPackageName));

        return tourRepository.save(new Tour(title, description,blurb,
                price, duration, bullets, keywords, tourPackage, difficulty, region));
    }

    /**
     * Calculate the number of Tours in the Database.
     *
     * @return the total.
     */
    public long total() {
        return tourRepository.count();
    }



}