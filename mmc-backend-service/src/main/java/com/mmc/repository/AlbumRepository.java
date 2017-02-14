package com.mmc.repository;

import com.mmc.entity.AlbumEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SGaurav on 15/12/2016.
 */
@Repository
public interface AlbumRepository extends CrudRepository<AlbumEntity , String>{
}
