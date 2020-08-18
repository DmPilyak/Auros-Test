package com.aurostest.aurostest.dao;

import java.util.List;

import com.aurostest.aurostest.model.KPacSetModel;

public interface KPacSetDao {
	void addSet(KPacSetModel kpacSet); 
	void removeSet(int id);
	List<KPacSetModel> getAllKPacSets();
}
