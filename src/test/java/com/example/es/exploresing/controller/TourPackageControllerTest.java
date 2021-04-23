//package com.example.es.exploresing.controller;
//
//import com.example.es.exploresing.entity.TourPackage;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.context.ApplicationContext;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class TourPackageControllerTest {
//
//    @LocalServerPort
//    int randomServerPort;
//
//    @Test
//    public  void getTourPackages() throws URISyntaxException {
//
//        final String baseUrl = "http://localhost"+randomServerPort+"/tourPackages";
//        URI uri=new URI(baseUrl);
//        TourPackage tourPackage=new TourPackage("TS","TEST TOUR PACKAGE");
//        webTestClient.get().uri("/tourPackages").exchange().expectStatus().isOk()
//                .expectHeader().contentType(MediaType.APPLICATION_JSON)
//                .expectBody().json(expectedJson);
//    }
//
//    @Test
//    void createTourPackages() {
//    }
//}