package com.ticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer>{

}
