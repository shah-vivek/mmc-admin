package com.mmc.service;

import com.mmc.entity.PresidentCornerEntity;
import com.mmc.model.PresidentCorner;
import com.mmc.repository.PresidentCornerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SGaurav on 20/10/2017.
 */
@Service
public class PresidentCornerServiceImpl implements PresidentCornerService {

    @Autowired
    private PresidentCornerRepository presidentCornerRepository;

    public void add(PresidentCorner presidentCorner) throws Exception {
        String uniqueId = UUID.randomUUID().toString();
        presidentCorner.setId(uniqueId);
        presidentCornerRepository.save(new PresidentCornerEntity(presidentCorner));
    }

    public void update(PresidentCorner presidentCorner) throws Exception {
        presidentCornerRepository.save(new PresidentCornerEntity(presidentCorner));
    }

    public PresidentCorner get() throws Exception {
        List<PresidentCorner> presidentCornerList = new ArrayList<>();
        Iterable<PresidentCornerEntity> presidentCornerEntities = presidentCornerRepository.findAll();

        for(PresidentCornerEntity presidentCornerEntity: presidentCornerEntities) {
            return new PresidentCorner(presidentCornerEntity);
        }

        return new PresidentCorner();
    }
}
