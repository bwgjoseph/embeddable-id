package com.sample;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "PEOPLE_STATS")
public class PeopleStats implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private PeopleStatsId peopleStatsId;

	@MapsId("peopleId")
	@JoinColumn(name = "people_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private People people;

	@MapsId("statsId")
    @JoinColumn(name = "stats_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stats stats;

    private long value;

}