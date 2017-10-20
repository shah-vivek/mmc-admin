package com.mmc.service;

import com.mmc.model.MMC;

/**
 * Created by SGaurav on 20/10/2017.
 */
public interface MMCService {
    void add(MMC mmc) throws Exception;

    void update(MMC mmc) throws Exception;

    MMC get() throws Exception;
}
