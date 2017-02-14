package com.mmc.repository;

import com.mmc.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SGaurav on 31/12/2016.
 */
@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, String> {
}
