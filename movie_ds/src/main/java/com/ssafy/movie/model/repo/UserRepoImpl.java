package com.ssafy.movie.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.ssafy.moive.model.dto.User;
import com.ssafy.moive.util.DBUtil;


@Repository
public class UserRepoImpl implements UserRepo {
	@Autowired
	DataSource ds;
	@Autowired
	DBUtil util;
	
	@Override
	public User select(String id) throws SQLException {
		User user = null;
		
		String sql = "select * from user where id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		}finally {
			util.close(rs,pstmt,con);
		}
		return user;
	}
	
	 public static void main(String[] args) throws Exception{ 
		 ApplicationContext ctx=new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml"); 
	 UserRepo repo=(UserRepo)ctx.getBean("userRepoImpl");
	 System.out.println(repo.select("ssafy")); 
	 }
	

}
