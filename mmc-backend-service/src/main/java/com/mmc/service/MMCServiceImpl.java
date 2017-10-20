package com.mmc.service;

import com.mmc.entity.MMCEntity;
import com.mmc.model.MMC;
import com.mmc.repository.MMCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SGaurav on 20/10/2017.
 */
@Service
public class MMCServiceImpl implements MMCService {

    @Autowired
    private MMCRepository mmcRepository;

    public void add(MMC mmc) throws Exception {
        String uniqueId = UUID.randomUUID().toString();
        mmc.setId(uniqueId);
        mmcRepository.save(new MMCEntity(mmc));
    }

    public void update(MMC presidentCorner) throws Exception {
        mmcRepository.save(new MMCEntity(presidentCorner));
    }

    public MMC get() throws Exception {
        List<MMC> presidentCornerList = new ArrayList<>();
        Iterable<MMCEntity> presidentCornerEntities = mmcRepository.findAll();

        for(MMCEntity presidentCornerEntity: presidentCornerEntities) {
            return new MMC(presidentCornerEntity);
        }

        return new MMC();
    }
}
