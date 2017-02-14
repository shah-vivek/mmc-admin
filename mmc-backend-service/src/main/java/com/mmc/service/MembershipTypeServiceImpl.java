package com.mmc.service;

import com.mmc.entity.MembershipTypeEntity;
import com.mmc.model.MembershipType;
import com.mmc.repository.MembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SGaurav on 09/12/2016.
 */
@Service
public class MembershipTypeServiceImpl {

    @Autowired
    private MembershipTypeRepository membershipTypeRepository;

    public void add(MembershipType membershipType) throws Exception {
        membershipTypeRepository.save(new MembershipTypeEntity(membershipType));
    }

    public void update(MembershipType membershipType) throws Exception {
        membershipTypeRepository.save(new MembershipTypeEntity(membershipType));
    }

    public void delete(MembershipType membershipType) throws Exception {
        membershipTypeRepository.delete(new MembershipTypeEntity(membershipType));
    }

    public List<MembershipType> list() throws Exception {
        List<MembershipType> membershipTypeList = new ArrayList<MembershipType>();
        Iterable<MembershipTypeEntity> membershipTypeEntities = membershipTypeRepository.findAll();

        for(MembershipTypeEntity membershipTypeEntity : membershipTypeEntities
                ){
            membershipTypeList.add( new MembershipType(membershipTypeEntity));
        }

        return membershipTypeList;
    }
}
