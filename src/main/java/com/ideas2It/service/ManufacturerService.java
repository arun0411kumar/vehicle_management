package com.ideas2It.service;

import java.sql.SQLException;
import java.util.List;

import com.ideas2It.dto.ManufacturerDto;
import com.ideas2It.util.customException.VehicleManagementException;

/**
 * This interface handles manufacturer crud operation
 *
 * @version 1.0
 * @author arunkumar
 */
public interface ManufacturerService {

	/**
	 * This method create manufacturer object and return it
	 * @param manufacturer
	 * @throws VehicleManagementException
	 * 
	 * @return its return two wheeler object
	 */
	public ManufacturerDto createManufacturer(ManufacturerDto manufacturerDto)
			throws VehicleManagementException;
	
	/**
	 * This method was return manufacturer details
	 * 
	 * @throws SQLException
	 * @return its return manufacturer details
	 */
	public List<ManufacturerDto> getManufacturers() throws VehicleManagementException;
	
	/**
	 * This method gets user given input whether it's in, then it will return
	 * object
	 *
	 * @param manufacturerId
	 * @throws VehicleManagementException
	 * @return its return Manufacturer object
	 */
	public ManufacturerDto getManufacturerById(int manufacturerId) throws VehicleManagementException;
	
	/**
	 * This method gets user given input whether its in then it will remove object
	 *
	 * @param manufacturerId
	 * @throws VehicleManagementException
	 * @return if object removed it return true, else it return false
	 */
	public boolean deleteManufacturerById(int manufacturerId) throws VehicleManagementException;

	/**
	 * Gets manufacturer id then change the specified value
	 *
	 * @param manufacturerId
	 * @param result
	 * @throws VehicleManagementException
	 * @return if value updated then it return true, else it return false
	 */
	public boolean updateManufacturerById(int manufacturerId, ManufacturerDto manufacturerDto)  throws VehicleManagementException;
}