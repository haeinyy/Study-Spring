package com.ssafy.movie.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.ssafy.movie.model.dto.Movie;
import com.ssafy.movie.model.dto.User;
import com.ssafy.movie.util.DBUtil;

@Repository
public class MovieRepoImpl implements MovieRepo {
	
	@Autowired
	private DBUtil dbUtil;
	
	@Autowired
	private DataSource dataSource;

	@Override
	public int insert(Movie m) throws SQLException {
		int result = -1;
		
		String sql="insert into movie values (?,?,?,?)\n";
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getCode());
			ps.setString(2, m.getTitle());
			ps.setInt(3, m.getPrice());
			ps.setString(4, m.getNo());
			
			result = ps.executeUpdate();
		} finally {
			dbUtil.close(con,ps);
		}
		return result;
	}

	@Override
	public Movie select(String code) throws SQLException {
		Movie m = null;
		
		String sql="select * from movie m join type t \n";
		sql += "on m.no = t.no \n";
		sql += "where m.code=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, code);
			
			rs=ps.executeQuery(); // sql 실행
			if(rs.next()) { 		// code
				m = new Movie(rs.getString(1), rs.getString("title"), rs.getInt("price"),
						rs.getString("no"),rs.getString("name"));
			}
		} finally {
			dbUtil.close(con,ps,rs);
		}
		return m;
	}

	@Override
	public List<Movie> search() throws SQLException {
		List<Movie> movies = new ArrayList<Movie>();
		
		String sql="select * from movie m join type t \n";
		sql += "on m.no = t.no ";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			
			rs=ps.executeQuery(); // sql 실행
			while(rs.next()) { 		// code
				Movie m= new Movie(rs.getString(1), rs.getString("title"), rs.getInt("price"),
						rs.getString("no"),rs.getString("name"));
				movies.add(m);
			}
		} finally {
			dbUtil.close(con,ps,rs);
		}
		
		return movies;
	}

	@Override
	public List<Movie> selectTitle(String title) throws SQLException {
		List<Movie> movies = new ArrayList<Movie>();
		
		String sql="select * from movie m join type t \n";
		sql += "on m.no = t.no \n";
		sql += "where m.title like ?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+title+"%");
			
			rs=ps.executeQuery(); // sql 실행
			while(rs.next()) { 		// code
				Movie m= new Movie(rs.getString(1), rs.getString("title"), rs.getInt("price"),
						rs.getString("no"),rs.getString("name"));
				movies.add(m);
			}
		} finally {
			dbUtil.close(con,ps,rs);
		}
		
		return movies;
	}

	@Override
	public List<Movie> selectPrice(int price) throws SQLException {
		List<Movie> movies = new ArrayList<Movie>();
		
		String sql="select * from movie m join type t \n";
		sql += "on m.no = t.no \n";
		sql += "where m.price <= ?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, price);
			
			rs=ps.executeQuery(); // sql 실행
			while(rs.next()) { 		// code
				Movie m= new Movie(rs.getString(1), rs.getString("title"), rs.getInt("price"),
						rs.getString("no"),rs.getString("name"));
				movies.add(m);
			}
		} finally {
			dbUtil.close(con,ps,rs);
		}
		
		return movies;
	}

	@Override
	public int delete(String code) throws SQLException {
		int result = -1;
		
		String sql="delete from movie where code=? ";
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, code);
			
			result = ps.executeUpdate();
		} finally {
			dbUtil.close(con,ps);
		}
		return result;
	}

	@Override
	public int update(Movie m) throws SQLException {
		int result = -1;
		
		String sql="update movie set title=?, price=?, no=?, where code=? ";
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getTitle());
			ps.setInt(2, m.getPrice());
			ps.setString(3, m.getNo());
			ps.setString(4, m.getCode());
			
			result = ps.executeUpdate();
		} finally {
			dbUtil.close(con,ps);
		}
		return result;
	}

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		MovieRepo mrepo = (MovieRepo) context.getBean("movieRepoImpl");
		Movie m = new Movie("104", "타이틀", 5000, "sf", "");
		
		System.out.println(mrepo.insert(m));
		for(Movie v:mrepo.search()) System.out.println(v);
		
		System.out.println(mrepo.select("101"));
		System.out.println();
		
		for(Movie v:mrepo.search()) System.out.println(v);
		System.out.println();
		
		m.setTitle("변경");
		m.setPrice(8000);
		m.setNo("dr");
		System.out.println(mrepo.update(m));
		for(Movie v:mrepo.search()) System.out.println(v);
		
		for(Movie v:mrepo.selectTitle("호")) System.out.println(v);
		System.out.println();
		
		System.out.println(mrepo.selectPrice(7000));
		for(Movie v:mrepo.search()) System.out.println(v);
		
		System.out.println();
		System.out.println(mrepo.delete("104"));
		for(Movie v:mrepo.search()) System.out.println(v);
		
		
	}
}
