package com.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.entity.Asset;
import com.ticket.helper.TicketAppResponse;
import com.ticket.service.AssetService;


@RestController
@CrossOrigin
public class AssetController {

	private AssetService assetService;
	
	@Autowired
	public AssetController(AssetService assetService) {
		this.assetService = assetService;
	}
	
	@GetMapping("/assets")
	public TicketAppResponse<List<Asset>> getAssets() {
		List<Asset> assetList = assetService.findAll();
		return new TicketAppResponse<List<Asset>>(HttpStatus.OK, "Assets Found", assetList);
	}
	
	@GetMapping(path="/getAsset/{asset_id}")
	public TicketAppResponse<Asset> getAssetbyId(@PathVariable int asset_id) {
		Asset assetObject;
		try {
			assetObject = assetService.findById(asset_id);
		} catch (Exception e) {
			e.printStackTrace();
			return new TicketAppResponse<Asset>(HttpStatus.OK, "Asset Found", null);
		}
		return new TicketAppResponse<Asset>(HttpStatus.OK, "Asset Found", assetObject);
	}
	
	@PostMapping(path="/addAsset")
	public TicketAppResponse<String> addAsset(@RequestBody Asset assetObject) throws Exception {
		assetService.save(assetObject);
		return new TicketAppResponse<String>(HttpStatus.OK, "Asset added", "Asset Added Successfully to database");
	}
	
	@DeleteMapping(value="/deleteAsset/{asset_id}")
	public TicketAppResponse<String> deleteAssetById(@PathVariable int asset_id) {
		try {
			assetService.deleteById(asset_id);
			return new TicketAppResponse<String>(HttpStatus.OK, "Asset deleted", "Asset Deleted from database");
		} catch (Exception e) {
			e.printStackTrace();
			return new TicketAppResponse<String>(HttpStatus.INTERNAL_SERVER_ERROR, "Error Occured", "No Records Deleted");
		}
		
	}
}
