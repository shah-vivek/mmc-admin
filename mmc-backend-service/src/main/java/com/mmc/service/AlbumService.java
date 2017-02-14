package com.mmc.service;

import com.mmc.model.Album;
import java.util.List;

/**
 * Created by SGaurav on 15/12/2016.
 */
public interface AlbumService {

    void add(Album album) throws Exception;

     List<Album> get() throws Exception;

    void rename(Album album) throws Exception;

    void delete(Album album) throws Exception;
}
