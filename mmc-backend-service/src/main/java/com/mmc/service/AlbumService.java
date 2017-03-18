package com.mmc.service;

import java.util.List;

import com.mmc.entity.AlbumInfoEntity;
import com.mmc.entity.AlbumYearEntity;
import com.mmc.model.Album;

/**
 * Created by SGaurav on 15/12/2016.
 */
public interface AlbumService {

    void add(Album album) throws Exception;

     List<Album> get() throws Exception;

    void rename(Album album) throws Exception;

    void delete(Album album) throws Exception;
    
    List<AlbumYearEntity> getAlbumsInfo() throws Exception;

	AlbumInfoEntity getAlbumImagePaths(String albumName, String year) throws Exception;
}
