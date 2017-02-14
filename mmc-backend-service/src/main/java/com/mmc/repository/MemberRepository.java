package com.mmc.repository;

import com.mmc.entity.MemberEntity;
import com.mmc.entity.MemberEntityPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SGaurav on 05/12/2016.
 */
@Repository
public interface MemberRepository extends CrudRepository<MemberEntity , MemberEntityPK> {

    @Query("Select ob from com.mmc.entity.MemberEntity ob where ob.memberEntityPk.email = ?1")
    MemberEntity findByEmail(String email);


}
