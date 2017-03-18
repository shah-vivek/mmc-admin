package com.mmc.entity;

import java.util.List;

public class AlbumInfoEntity {
	private String albumName;
	private List<String> albumImagePaths;
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public List<String> getAlbumImagePaths() {
		return albumImagePaths;
	}
	public void setAlbumImagePaths(List<String> albumImagePaths) {
		this.albumImagePaths = albumImagePaths;
	}
}
