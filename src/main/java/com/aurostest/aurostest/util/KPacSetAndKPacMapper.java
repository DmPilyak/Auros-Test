package com.aurostest.aurostest.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aurostest.aurostest.model.KPacSetAndKPacModel;

public class KPacSetAndKPacMapper implements RowMapper<KPacSetAndKPacModel> {

	@Override
	public KPacSetAndKPacModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		KPacSetAndKPacModel kpacSetAndKPac = new KPacSetAndKPacModel();
		kpacSetAndKPac = new KPacSetAndKPacModel();
		kpacSetAndKPac.setId_set(rs.getInt("id_set"));
		kpacSetAndKPac.setId_kpac(rs.getInt("id_kpac"));
		
        return kpacSetAndKPac;
	}

}
