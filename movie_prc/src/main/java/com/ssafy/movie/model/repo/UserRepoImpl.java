package com.ssafy.movie.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.ssafy.movie.model.dto.User;
import com.ssafy.movie.util.DBUtil;

@Repository
public class UserRepoImpl implements UserRepo {
	
	@Autowired
	private DBUtil dbUtil;
	
	@Autowired
	private DataSource dataSource;

	@Override
	public User select(String id) throws Exception {
		User user = null;
		String sql = "select * from user where id=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				user = new User(rs.getString(1), rs.getString("pass"), rs.getString("name"));
			}
		}finally {
			dbUtil.close(con,ps,rs);
		}
		return user;
	}
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		UserRepo user = (UserRepo) context.getBean("userRepoImpl");
		System.out.println(user.select("ssafy"));
	}

}
