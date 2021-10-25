package com.ssafy.phone.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.ssafy.phone.model.dto.Phone;
import com.ssafy.phone.util.DBUtil;

@Repository
public class IPhoneDAOImpl implements IPhoneDAO {

	@Autowired
	private DBUtil dbUtil;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public int insert(Phone p) throws Exception {
		int result=-1;
		
		String sql = "insert into phones values (?,?,?)"; // foreignkey는 제외하고 insert
		Connection con = null;
		PreparedStatement ps=null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getNum());
			ps.setString(2, p.getModel());
			ps.setInt(3, p.getPrice());
			
			result = ps.executeUpdate();
		} finally {
			dbUtil.close(con,ps);
		}
		return result;
	}

	@Override
	public List<Phone> search() throws Exception {
		List<Phone> plist = new ArrayList<Phone>();
		String sql = "select * from phones p join company c \n";
		sql += "on p.vcode=c.vcode \n";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Phone p = new Phone(rs.getString("num"), rs.getString("model"), rs.getInt("price"), rs.getString("vcode"), rs.getString("vendor"));
				plist.add(p);
			}
		}finally{
			dbUtil.close(con,ps,rs);
		}
		return plist;
	}

	@Override
	public Phone select(String num) throws Exception {
		Phone p = null;
		String sql = "select * from phones p join company c \n";
		sql += "on p.vcode=c.vcode \n";
		sql += "where num=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, num);
			rs=ps.executeQuery();
			if(rs.next()) {
				p = new Phone(rs.getString(1), rs.getString("model"), rs.getInt("price"), rs.getString("vcode") ,rs.getString("vendor"));
			}
		}finally {
			dbUtil.close(con,ps,rs);
		}
		return p;
	}

	@Override
	public int delete(String num) throws Exception {
		int result = -1;
		String sql = "delete from phones where num=?";
		Connection con = null;
		PreparedStatement ps=null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, num);
			
			result = ps.executeUpdate();
		}finally {
			dbUtil.close(con,ps);
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		IPhoneDAO pdao = (IPhoneDAO) ctx.getBean("IPhoneDAOImpl");
		for(Phone v:pdao.search()) System.out.println(v);
		
		System.out.println(pdao.select("S105G"));
		System.out.println();
		
		System.out.println(pdao.delete("S105G"));
	}
}
