package com.sample;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Domain Repository for {@link Stats}
 * 
 */
@Repository
public interface StatsRepository extends CrudRepository<Stats, Long>{

}
