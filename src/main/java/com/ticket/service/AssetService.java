package com.ticket.service;

import java.util.List;

import com.ticket.entity.Asset;

public interface AssetService {

	public List<Asset> findAll();

	public Asset findById(int assetId) throws Exception;

	public void save(Asset assetObject);

	public void deleteById(int assetId);
	
}