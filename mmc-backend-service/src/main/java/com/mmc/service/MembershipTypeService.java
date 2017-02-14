package com.mmc.service;

import com.mmc.model.MembershipType;
import java.util.List;

/**
 * Created by SGaurav on 09/12/2016.
 */
public interface MembershipTypeService {

    void add(MembershipType membershipType) throws Exception;

    void update(MembershipType membershipType) throws Exception;

    void delete(MembershipType membershipType) throws Exception;

    List<MembershipType> list() throws Exception;
}
