package com.ticket.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ticket.dao.AssetRepository;
import com.ticket.entity.Asset;
import com.ticket.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService {

	private AssetRepository assetRepository;
	
	public AssetServiceImpl(AssetRepository assetRepository) {
		this.assetRepository = assetRepository;
	}
	
	@Transactional
	public List<Asset> findAll() {
		return assetRepository.findAll();
	}
	
	@Transactional
	public Asset findById(int assetId) throws Exception {
		Optional<Asset> optionalAsset = assetRepository.findById(assetId);
		Asset assetObject = null;
		if (optionalAsset.isPresent()) {
			assetObject = optionalAsset.get();
		} else {
			throw new Exception("Did not find Asset with id - " + assetId);
		}
		return assetObject;
	}

	@Transactional
	public void save(Asset assetObject) {
		assetRepository.save(assetObject);
	}

	@Transactional
	public void deleteById(int assetId) {
		assetRepository.deleteById(assetId);
	}
	
}
