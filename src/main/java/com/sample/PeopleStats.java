package com.sample;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "PEOPLE_STATS")
public class PeopleStats implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private PeopleStatsId peopleStatsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("peopleId")
    private People people;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("statsId")
    private Stats stats;

    private long value;

}