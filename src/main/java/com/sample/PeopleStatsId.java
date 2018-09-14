package com.sample;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Embeddable
@EqualsAndHashCode
public class PeopleStatsId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Putting @Column(name = "people_id") or not doesn't seem to have any effect
    private long peopleId;
    // Same goes for this
    private long statsId;

}