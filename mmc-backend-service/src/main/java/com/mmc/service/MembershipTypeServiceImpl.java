package com.mmc.service;

import com.mmc.entity.MembershipTypeEntity;
import com.mmc.model.MembershipType;
import com.mmc.repository.MembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SGaurav on 09/12/2016.
 */
@Service
public class MembershipTypeServiceImpl {

    @Autowired
    private MembershipTypeRepository membershipTypeRepository;

    public void add(MembershipType membershipType) throws Exception {
        String uniqueID = UUID.randomUUID().toString();
        membershipType.setId(uniqueID);
        membershipTypeRepository.save(new MembershipTypeEntity(membershipType));
    }

    public void update(MembershipType membershipType) throws Exception {
        membershipTypeRepository.save(new MembershipTypeEntity(membershipType));
    }

    public void delete(String  membershipId) throws Exception {
        membershipTypeRepository.delete(membershipId);
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

    public MembershipType get(String membershipTypeId) throws Exception {
        MembershipTypeEntity membershipTypeEntity = membershipTypeRepository.findOne(membershipTypeId);
        return new MembershipType(membershipTypeEntity);
    }
}
