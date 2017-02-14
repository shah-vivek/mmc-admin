package com.mmc.service;

import com.mmc.entity.AlbumEntity;
import com.mmc.model.Album;
import com.mmc.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SGaurav on 15/12/2016.
 */
@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumRepository albumRepository;

    public void add(Album album) throws Exception{

        String uid = UUID.randomUUID().toString();
        album.setAlbumId(uid);

        albumRepository.save(new AlbumEntity(album));

    }

    public List<Album> get(){
        Iterable<AlbumEntity> albumEntities = albumRepository.findAll();
        List<Album> albumList = new ArrayList<Album>();
        for (AlbumEntity albumEntity: albumEntities){
            albumList.add(new Album(albumEntity));
        }
        return albumList;
    }

    public void rename(Album album){
        albumRepository.save(new AlbumEntity(album));
    }

    public void delete(Album album){
        albumRepository.delete(new AlbumEntity(album));
    }
}
