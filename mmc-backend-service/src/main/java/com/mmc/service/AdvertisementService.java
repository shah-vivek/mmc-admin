package com.mmc.service;

import com.mmc.model.Advertisement;

import java.util.List;
/**
 * Created by SGaurav on 01/01/2017.
 */
public interface AdvertisementService {

    void add(Advertisement advertisement) throws Exception;

    void delete(String id) throws Exception;

    void update(Advertisement advertisement) throws Exception;

    List<Advertisement> list() throws Exception;

    Advertisement get(String id) throws Exception;
}
