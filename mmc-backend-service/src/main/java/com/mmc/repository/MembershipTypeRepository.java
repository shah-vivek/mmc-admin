package com.mmc.repository;

import com.mmc.entity.MembershipTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SGaurav on 09/12/2016.
 */
@Repository
public interface MembershipTypeRepository extends CrudRepository<MembershipTypeEntity , String>{
}
