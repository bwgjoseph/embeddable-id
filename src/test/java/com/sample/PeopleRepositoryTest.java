package com.sample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PeopleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private StatsRepository statsRepository;
    
    @Test
    public void testSavePeopleWithOneStats() {
    	
        // Creates People entity
    	People people = this.generatePeopleWithoutId();
    	// Retrieve existing stats from StatsRepository
    	Stats stats = this.statsRepository.findById(new Long(1)).get();
    	// Add Stats to People
        people.addStats(stats);
        // Persist and retrieve
        People p = this.entityManager.persistFlushFind(people);
        
        assertThat(p.getPeopleStats().size()).isEqualTo(1);
    }
    
    @Test
    public void testSavePeopleWithAllStats() {
    	
    	// Creates People entity
    	People people = this.generatePeopleWithoutId();
    	// Retrieve all existing stats from StatsRepository and add to People
    	this.statsRepository.findAll().forEach(stats -> people.addStats(stats));
    	// Persist and retrieve
    	People p = this.entityManager.persistFlushFind(people);
        
        assertThat(p.getPeopleStats().size()).isEqualTo(3);
    }
    
    public People generatePeopleWithoutId() {
		
		return People.builder()
				.peopleName("name")
				.build();
	}
}