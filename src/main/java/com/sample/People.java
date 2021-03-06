package com.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Builder
@Table(name = "PEOPLE")
public class People implements Serializable {

	private static final long serialVersionUID = 1L;
 
	@Id
    @SequenceGenerator(name = "people", sequenceName = "people_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "people")
    private long peopleId;

    private String peopleName;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "people", 
            cascade = CascadeType.ALL, 
            orphanRemoval = true
    )
    private List<PeopleStats> peopleStats;

    // Maintain the state of objects association
    public void addStats(Stats stats) {

        if (this.peopleStats == null) {
            this.peopleStats = new ArrayList<>();
        }
        
        // Important to ensure that a new instance of PeopleStatsId is being passed into the field
        // otherwise, PropertyAccessException will be encountered
        PeopleStats pStats = PeopleStats.builder()
        						.people(this)
        						.stats(stats)
        						.peopleStatsId(new PeopleStatsId(this.getPeopleId(), stats.getStatsId()))
        						.build();

        this.peopleStats.add(pStats);
    }
    
}