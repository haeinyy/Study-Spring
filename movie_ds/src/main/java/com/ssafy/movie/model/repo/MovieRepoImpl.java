package com.ssafy.movie.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ssafy.moive.model.dto.Movie;
import com.ssafy.moive.util.DBUtil;


@Repository
public class MovieRepoImpl implements MovieRepo {
	@Autowired
	DataSource ds;
	@Autowired
	DBUtil util;
	@Override
	public int insert(Movie m) throws SQLException {
		int result=-1;
        
        String sql="insert into movie values (?,?,?,?)";
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=ds.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,m.getCode());
            ps.setString(2,m.getTitle());
            ps.setInt(3,m.getPrice());
            ps.setString(4,m.getNo());
            
            result=ps.executeUpdate();
        }finally {
            util.close(ps,con);
        }
        
        return result;
	}

	@Override
	public Movie select(String code) throws SQLException {
		Movie m = null;
		
		String sql="select * from movie join type on movie.no=type.no where movie.code=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m = new Movie(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5));
			}
		}finally {
			util.close(rs,pstmt,con);
		}
		return m;
	}

	@Override
	public List<Movie> search() throws SQLException {
		List<Movie> movies=new ArrayList<Movie>();
        
        String sql="select * from movie m join type t on m.no=t.no";
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=ds.getConnection();
            ps=con.prepareStatement(sql);
            
            rs=ps.executeQuery();
            while(rs.next()) {        //"code"
                Movie m=new Movie(rs.getString(1),rs.getString("title"),rs.getInt("price"),
                                  rs.getString("no"),rs.getString("name"));
                movies.add(m);
            }
        }finally {
            util.close(rs,ps,con);
        }
        
        return movies;
	}

	@Override
	public List<Movie> searchTitle(String title) throws SQLException {
		 List<Movie> movies=new ArrayList<Movie>();
	        
	        String sql="select * from movie m join type t on m.no=t.no where m.title like ?";
	        Connection con=null;
	        PreparedStatement ps=null;
	        ResultSet rs=null;
	        try {
	            con=ds.getConnection();
	            ps=con.prepareStatement(sql);
	            ps.setString(1,"%"+title+"%");
	            
	            rs=ps.executeQuery();
	            while(rs.next()) {        //"code"
	                Movie m=new Movie(rs.getString(1),rs.getString("title"),rs.getInt("price"),
	                                  rs.getString("no"),rs.getString("name"));
	                movies.add(m);
	            }
	        }finally {
	            util.close(rs,ps,con);
	        }
	        
	        return movies;
	}

	@Override
	public List<Movie> searchPrice(int price) throws SQLException {
        List<Movie> movies=new ArrayList<Movie>();
        
        String sql="select * from movie m join type t on m.no=t.no where m.price<=?";
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=ds.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,price);
            
            rs=ps.executeQuery();
            while(rs.next()) {        //"code"
                Movie m=new Movie(rs.getString(1),rs.getString("title"),rs.getInt("price"),
                                  rs.getString("no"),rs.getString("name"));
                movies.add(m);
            }
        }finally {
            util.close(rs,ps,con);
        }
        
        return movies;
	}

	@Override
	public int delete(String code) throws SQLException {
        int result=-1;
        
        String sql="delete from movie where code=?";
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=ds.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,code);
            
            result=ps.executeUpdate();
        }finally {
            util.close(ps,con);
        }
        
        return result;
	}

	@Override
	public int update(Movie m) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
