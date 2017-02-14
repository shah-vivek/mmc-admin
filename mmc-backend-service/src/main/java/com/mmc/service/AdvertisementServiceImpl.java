package com.mmc.service;

import com.mmc.entity.AdvertisementEntity;
import com.mmc.model.Advertisement;
import com.mmc.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SGaurav on 01/01/2017.
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService  {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    public void add(Advertisement advertisement) throws Exception {
        AdvertisementEntity advertisementEntity = new AdvertisementEntity(advertisement);
        String id = UUID.randomUUID().toString();
        advertisementEntity.setAdsId( id );
        System.out.println("Adding advertisement ===================>" + advertisementEntity.toString());
        advertisementRepository.save(advertisementEntity);
    }

    public void delete(String id) throws Exception {
        advertisementRepository.delete(id);
    }

    public void update(Advertisement advertisement) throws Exception {
        AdvertisementEntity advertisementEntity = new AdvertisementEntity(advertisement);
        advertisementRepository.save(advertisementEntity);
    }

    public List<Advertisement> list() throws Exception {
        List<Advertisement> advertisements = new ArrayList<Advertisement>();
        Iterable<AdvertisementEntity> advertisementEntities = advertisementRepository.findAll();

        for(AdvertisementEntity advertisementEntity : advertisementEntities) {
            advertisements.add(new Advertisement(advertisementEntity));
        }
        return advertisements;
    }

    public Advertisement get(String id) throws Exception {
        Advertisement advertisement = new Advertisement( advertisementRepository.findOne(id));
        return advertisement;
    }

}
