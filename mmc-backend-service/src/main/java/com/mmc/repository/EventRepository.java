package com.mmc.repository;

import com.mmc.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SGaurav on 06/12/2016.
 */
@Repository
public interface EventRepository extends JpaRepository<EventEntity , String> {
}
