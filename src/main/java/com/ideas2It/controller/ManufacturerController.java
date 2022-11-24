package com.ideas2It.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2It.model.Manufacturer;
import com.ideas2It.service.ManufacturerService;
import com.ideas2It.util.customException.VehicleManagementException;

@RestController
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@PostMapping(value = "/createManufacturer")
	public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer) {
		try {
			manufacturer = manufacturerService.createManufacturer(manufacturer);
		} catch (VehicleManagementException e) {
			manufacturer = null;
			e.printStackTrace();
		}
		return manufacturer;
	}
	
	@GetMapping(value = "/getManufacturers")
	public List<Manufacturer> getManufacturers() {
		List<Manufacturer> manufacturers = null;
        try {
			manufacturers = manufacturerService.getManufacturers();
		} catch (VehicleManagementException e) {
			e.printStackTrace();
		}
		return manufacturers;
	}
	
	@GetMapping(value = "/getManufacturer/{id}")
	public Manufacturer getManufacturerById(@PathVariable("id") Integer id) {
		Manufacturer manufacturer = null;
		try {
			manufacturer = manufacturerService.getManufacturerById(id);
		} catch (VehicleManagementException e) {
			e.printStackTrace();
		}
		return manufacturer;
	}
	
	@DeleteMapping(value = "/deleteManufacturer/{id}")
	public String deleteManufacturerById(@PathVariable("id") Integer id) {
		String status = "";
		try {
			if (manufacturerService.deleteManufacturerById(id)) {
				status = "deleted successfully";
			}
		} catch (VehicleManagementException e) {
			status = "not deleted successfully";
			e.printStackTrace();
		}
		return status;
	}
	
	@PutMapping(value = "/updateManufacturer/{id}")
	public String updateManufacturerById(@PathVariable("id") Integer id, 
			@RequestBody Manufacturer manufacturer) {
		String status = "";
		try {
			if (manufacturerService.updateManufacturerById(id, manufacturer)) {
				status = "updated successfully";
			}
		} catch (VehicleManagementException e) {
			status = "not updated successfully";
			e.printStackTrace();
		}
		return status;
	}
}