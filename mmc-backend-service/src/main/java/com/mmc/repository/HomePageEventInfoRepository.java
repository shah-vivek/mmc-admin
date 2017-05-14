package com.mmc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmc.entity.HomePageEventInfoEntity;

@Repository
public interface HomePageEventInfoRepository extends JpaRepository<HomePageEventInfoEntity, String> {

}
