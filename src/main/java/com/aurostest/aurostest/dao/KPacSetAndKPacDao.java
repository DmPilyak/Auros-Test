package com.aurostest.aurostest.dao;

import java.util.List;

import com.aurostest.aurostest.model.KPacModel;

public interface KPacSetAndKPacDao {
	void remove(int id_set, int id_kpac);
	void insert(int id_set, int id_kpac);
	List<KPacModel> getAllKPacSetsAndKPac();
}
