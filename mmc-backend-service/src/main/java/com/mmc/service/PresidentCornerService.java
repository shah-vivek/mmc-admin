package com.mmc.service;

import com.mmc.model.PresidentCorner;

/**
 * Created by SGaurav on 20/10/2017.
 */
public interface PresidentCornerService {

    void add(PresidentCorner presidentCorner) throws Exception;

    void update(PresidentCorner presidentCorner) throws Exception;

    PresidentCorner get() throws Exception;
}
