package com.raghav.brd4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.raghav.brd4.dto.Count;

public class EmpDAOImpl implements EmpDAO {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}


	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	class MyMapper implements RowMapper<Count>{

		@Override
		public Count mapRow(ResultSet rs, int rowNum) throws SQLException {
			Count dept=new Count();
			dept.setDept_id(rs.getString(1));
			dept.setCount(rs.getInt(2));
			return dept;
		}
	}

	@Override
	public List<Count> selectAll() {
		String query="select d.dept_id,count(e.emp_id) from rv_Department d inner join rv_Employee e on e.dept_id=d.dept_id group by d.dept_id";
		List<Count> list=jdbctemplate.query(query,new MyMapper());
		return list;
	}

}
