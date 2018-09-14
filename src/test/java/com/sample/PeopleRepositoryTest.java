package com.sample;

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

    @Test
    public void testSavePeople() {
    	
        // People object created
    	People people = this.generatePeopleWithoutId();
        people.addStats(Stats.builder().statsId(new Long(1)).statsName("a").statsDescription("b").build());

        this.entityManager.persistAndFlush(people);
    }
    
    public People generatePeopleWithoutId() {
		
		return People.builder()
				.peopleName("name")
				.build();
	}
}