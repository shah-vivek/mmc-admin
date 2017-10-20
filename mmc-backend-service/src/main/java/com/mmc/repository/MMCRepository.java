package com.mmc.repository;

import com.mmc.entity.MMCEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SGaurav on 20/10/2017.
 */
@Repository
public interface MMCRepository extends CrudRepository<MMCEntity,String> {
}
