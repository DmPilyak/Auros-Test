package com.aurostest.aurostest.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aurostest.aurostest.model.KPacModel;

public class KPacMapper implements RowMapper<KPacModel> {

	@Override
	public KPacModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		KPacModel kpac = new KPacModel();
		kpac = new KPacModel();
		kpac.setId(rs.getInt("id"));
		kpac.setTitle(rs.getString("Title"));
		kpac.setDescript(rs.getString("Description_k_pac"));
		kpac.setDate(rs.getString("Creation_date"));
        return kpac;
	}

}
