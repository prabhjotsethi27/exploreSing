package com.example.es.exploresing;

import com.example.es.exploresing.controller.TourPackageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class ExploresingApplicationTests {

	@Autowired
	private TourPackageController tourPackageController;

	@Test
	public void contextLoads() throws Exception{
		System.out.println("inside contextloads");
		assertThat(tourPackageController).isNotNull();
	}

}
