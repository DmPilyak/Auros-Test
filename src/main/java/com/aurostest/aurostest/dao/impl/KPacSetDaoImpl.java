package com.aurostest.aurostest.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aurostest.aurostest.dao.KPacSetDao;
import com.aurostest.aurostest.model.KPacSetModel;
import com.aurostest.aurostest.util.KPacSetMapper;

@Repository
public class KPacSetDaoImpl implements KPacSetDao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_KPAC_SET = "INSERT INTO auros_test_db.kpac_sets (Title) VALUES (?);";
	private static final String REMOVE_KPAC_SET = "DELETE FROM auros_test_db.kpac_sets WHERE id_set = ?; ";
	private static final String ALL_KPAC_SET = "SELECT * FROM auros_test_db.kpac_sets;";
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void addSet(KPacSetModel kpacSet) {
		jdbcTemplate.update(INSERT_KPAC_SET, kpacSet.getTitle());
	}

	@Override
	public void removeSet(int idSet) {
		jdbcTemplate.update(REMOVE_KPAC_SET, idSet);
	}

	@Override
	public List<KPacSetModel> getAllKPacSets() {
		List<KPacSetModel> kpacSetList = jdbcTemplate.query(ALL_KPAC_SET, new KPacSetMapper());
		return kpacSetList;
	}

}
