package com.mmc.repository;

import com.mmc.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SGaurav on 05/01/2017.
 */
@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, String> {
}
