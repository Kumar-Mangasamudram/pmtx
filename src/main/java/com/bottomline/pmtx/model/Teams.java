package com.bottomline.pmtx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="teams")
public class Teams {
	
	@Id
	@Column(name="team_name")
	private String team_name;
	
	@Column(name="team_size")
	private int team_size;

	public Teams() {
		super();
	}

	public Teams(String team_name, int team_size) {
		super();
		this.team_name = team_name;
		this.team_size = team_size;
	}


	public String getTeam_name() {
		return team_name;
	}


	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}


	public int getTeam_size() {
		return team_size;
	}


	public void setTeam_size(int team_size) {
		this.team_size = team_size;
	}
}
