package com.aurostest.aurostest.dao;

import java.util.List;

import javax.sql.DataSource;

import com.aurostest.aurostest.model.KPacModel;

public interface KPacDao {
	//void setDataSource(DataSource dataSource);
	KPacModel getKPacByID(int id);
	List<KPacModel> getAllKPacs();
	//void addKPac(String Title, String Description_k_pac, String Creation_date);
	void addKPac(KPacModel kpac);
	void removeKPac(int id);
}
