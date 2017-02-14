package com.mmc.repository;

import com.mmc.entity.AdvertisementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SGaurav on 01/01/2017.
 */
@Repository
public interface AdvertisementRepository extends CrudRepository<AdvertisementEntity , String> {
}
