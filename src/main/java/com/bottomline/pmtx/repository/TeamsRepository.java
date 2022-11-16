package com.bottomline.pmtx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bottomline.pmtx.model.Teams;


@Repository
public interface TeamsRepository extends JpaRepository<Teams, String>{
	


}
