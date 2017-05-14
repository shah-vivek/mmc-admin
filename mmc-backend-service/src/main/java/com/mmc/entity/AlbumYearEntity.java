package com.mmc.entity;

import java.util.List;

public class AlbumYearEntity {

	private String yearNumber;
	private List<AlbumCoverEntity> albumsList;
	public String getYearNumber() {
		return yearNumber;
	}
	public void setYearNumber(String yearNumber) {
		this.yearNumber = yearNumber;
	}
	public List<AlbumCoverEntity> getAlbumsList() {
		return albumsList;
	}
	public void setAlbumsList(List<AlbumCoverEntity> albumsList) {
		this.albumsList = albumsList;
	}
	
	

}
