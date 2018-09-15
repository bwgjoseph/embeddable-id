package com.sample;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Embeddable
public class PeopleStatsId implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private long peopleId;
    private long statsId;

}