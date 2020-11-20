package com.aurostest.aurostest.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aurostest.aurostest.dao.KPacDao;
import com.aurostest.aurostest.model.KPacModel;
import com.aurostest.aurostest.util.KPacMapper;

@Repository
public class KPacDaoImpl implements KPacDao {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_KPAC_BY_ID = "SELECT * FROM k_pac WHERE id = ?;";
	private static final String INSERT_KPAC = "INSERT INTO k_pac (Title, Description_k_pac, Creation_date) VALUES (?, ?, ?); ";
	private static final String REMOVE_KPAC = "DELETE FROM k_pac WHERE id = ?; ";
	private static final String SELECT_ALL_KPAC = "SELECT * FROM k_pac;";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public KPacModel getKPacByID(int id) {
		KPacModel developer = jdbcTemplate.queryForObject(SELECT_KPAC_BY_ID, new Object[] { id }, new KPacMapper());
		return developer;
	}

	@Override
	public List<KPacModel> getAllKPacs() {
		List<KPacModel> kpacList = jdbcTemplate.query(SELECT_ALL_KPAC, new KPacMapper());
		return kpacList;
	}

	@Override
	public void addKPac(KPacModel kpac) {
		jdbcTemplate.update(INSERT_KPAC, kpac.getTitle(), kpac.getDescript(), kpac.getDate());
	}

	@Override
	public void removeKPac(int id) {
		jdbcTemplate.update(REMOVE_KPAC, id);
	}

}
