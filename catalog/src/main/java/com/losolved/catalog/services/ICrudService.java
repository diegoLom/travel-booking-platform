package com.losolved.catalog.services;

import com.losolved.catalog.dto.ResponseDTO;

public interface ICrudService<C, DTO> {

	
	public ResponseDTO create(DTO dto);
	public ResponseDTO retrieve(DTO dto);
	public Flight retrieveAll(DTO dto);
		

}
