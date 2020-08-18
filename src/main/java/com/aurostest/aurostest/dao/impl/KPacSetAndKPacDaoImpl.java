package com.aurostest.aurostest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aurostest.aurostest.dao.KPacSetAndKPacDao;
import com.aurostest.aurostest.model.KPacModel;
import com.aurostest.aurostest.model.KPacSetAndKPacModel;
import com.aurostest.aurostest.model.KPacSetModel;
import com.aurostest.aurostest.util.KPacSetAndKPacMapper;
import com.aurostest.aurostest.util.KPacSetMapper;

public class KPacSetAndKPacDaoImpl implements KPacSetAndKPacDao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	private static final String REMOVE = "SET SQL_SAFE_UPDATES = 0; DELETE FROM auros_test_db.kpac_set_kpac WHERE id_set = ? AND id_kpac = ?;";
	private static final String INSERT = "INSERT INTO auros_test_db.kpac_set_kpac (id_set, id_kpac) VALUES (?, ?);";
	private static final String ID_KPAC = "SELECT id_kpac FROM auros_test_db.kpac_set_kpac WHERE id_set = ?";
	private static final String SELECT_KPACS_LIST = "SELECT id_kpac FROM auros_test_db.kpac_set_kpac WHERE id_set = ?";
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void remove(int id_set, int id_kpac) {
		jdbcTemplate.update(REMOVE, id_set, id_kpac);
	}

	@Override
	public void insert(int id_set, int id_kpac) {
		jdbcTemplate.update(INSERT, id_set, id_kpac);
	}

	@Override
	public List<KPacModel> getAllKPacSetsAndKPac() {
		List<KPacSetAndKPacModel> list_id_kpac = (List<KPacSetAndKPacModel>) jdbcTemplate.queryForObject(ID_KPAC, new Object[]{5}, new KPacSetAndKPacMapper());
		List<KPacModel> list_kpacs = new ArrayList<>();
		for (KPacSetAndKPacModel num : list_id_kpac) {
			//KPacSetAndKPacModel kpac = jdbcTemplate.queryForObject(SELECT_KPACS_LIST, new Object[]{5}, new KPacSetAndKPacMapper());
		}
		//List<KPacModel> list_kpacs = jdbcTemplate.queryForObject(SELECT_KPACS_LIST, new Object[]{5}, new KPacSetAndKPacMapper());
		
		return null;
	}

}
