package com.example.agendinaBE.service.settore;

import java.util.List;

import com.example.agendinaBE.model.SettoreEntity;


public  interface ISettoreService{
	List<SettoreEntity> findAllSettore();
	SettoreEntity createSettore(SettoreEntity dto);
	SettoreEntity  updateSettore ( SettoreEntity dto);
	void  deleteSettore(Long id);
}