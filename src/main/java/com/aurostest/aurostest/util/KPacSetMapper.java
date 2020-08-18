package com.aurostest.aurostest.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aurostest.aurostest.model.KPacSetModel;

public class KPacSetMapper implements RowMapper<KPacSetModel> {
	
	@Override
	public KPacSetModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		KPacSetModel kpacSet = new KPacSetModel();
		kpacSet = new KPacSetModel();
		kpacSet.setIdSet(rs.getInt("id_set"));
		kpacSet.setTitle(rs.getString("Title"));
		
        return kpacSet;
	}
}
