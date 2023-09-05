package com.addr.model;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class SAddrDAOImpl implements SAddrDAO {

	private static SAddrDAO instance = new SAddrDAOImpl();
	public static SAddrDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	@Override
	public void addrInsert(AddrDTO addr) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		
		try {
			con = getConnection();
			sql = "insert into address values(address_seq.nextval,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, addr.getName());
			ps.setString(2, addr.getZipcode());
			ps.setString(3, addr.getAddr());
			ps.setString(4, addr.getTel());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, ps, null);
		}
	}

	@Override
	public ArrayList<AddrDTO> addrList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<AddrDTO> arr = new ArrayList<>();
		String sql = "";
		
		
		try {
			con = getConnection();
			sql = "select * from address";
			st = con.createStatement();
			rs = st.executeQuery(sql);
		
			while(rs.next()) {
			   AddrDTO ad = new AddrDTO();
			   ad.setAddr(rs.getString("addr"));
			   ad.setName(rs.getString("name"));
			   ad.setNum(rs.getInt("num"));
			   ad.setTel(rs.getString("tel"));
			   ad.setZipcode(rs.getString("zipcode"));
			   arr.add(ad);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		   return arr;
	}
		
	@Override
	public AddrDTO addrDetail(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		AddrDTO a = null;
		String sql = "";
		
		try {
			con = getConnection();
			sql = "select * from address where num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				a = new AddrDTO();
				a.setAddr(rs.getString("addr"));
				a.setName(rs.getString("name"));
				a.setNum(rs.getInt("num"));
				a.setTel(rs.getString("tel"));
				a.setZipcode(rs.getString("zipcode"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		closeConnection(con, null, st, rs);	
		}
		return a;
	}

	@Override
	public void addrUpdate(AddrDTO addr) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		
		try {
			con = getConnection();
			sql = "update address set name=?, "
					+ "zipcode=?, tel=?, addr=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, addr.getName());
			ps.setString(2, addr.getZipcode());
			ps.setString(3, addr.getTel());
			ps.setString(4, addr.getAddr());
			ps.setInt(5, addr.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, ps, null);
		}		
	}

	@Override
	public void addrDelete(int num) {
		Connection con = null;
		Statement st = null;
		String sql = "";
		
		try {
			con = getConnection();
			st = con.createStatement();
			sql = "delete from address where num="+num;
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, null);
		}
		
	}

	@Override
	public ArrayList<AddrDTO> addrSearchList(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<AddrDTO> arr = new ArrayList<>();
		String sql = "";
		
		try {
			con = getConnection();
			st = con.createStatement();
			if(word.equals("")) { //검색아님
				 sql = "select * from address";
			}else {  //검색
				 sql = "select * from address where "+field+" like '%"+word+"%'"; // 수정하기
			}                                                         
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AddrDTO ad = new AddrDTO();
				ad.setAddr(rs.getString("addr"));
				ad.setName(rs.getString("name"));
				ad.setNum(rs.getInt("num"));
				ad.setTel(rs.getString("tel"));
				ad.setZipcode(rs.getString("zipcode"));
				arr.add(ad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
	 return arr;
	}
	
	@Override
	public int addrCount() {
		int count = 0;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = getConnection();
			sql = "select count(*) from address";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return count;
	}
	
	@Override
	public ArrayList<ZipDTO> addrZipRead(String dong) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipDTO> zarr = new ArrayList<>();
		String sql="";
		
		try {
			con = getConnection();
			st = con.createStatement();
			sql = "select * from zipcode where dong like '%"+dong+"%'";
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
			ZipDTO zip = new ZipDTO();
			zip.setBunji(rs.getString("bunji"));
			zip.setDong(rs.getString("dong"));
			zip.setGugun(rs.getString("gugun"));
			zip.setSido(rs.getString("sido"));
			zip.setZipcode(rs.getString("zipcode"));
			zarr.add(zip);	
			}	
			} catch (Exception e) {
			e.printStackTrace();
		}
		return zarr;
	}

	@Override
	public void fileInsert(FileDTO file) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		
		try {
			con=getConnection();
			sql="insert into imagetest values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, file.getName());
			ps.setString(2, file.getTitle());
			ps.setString(3, file.getImage());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, ps, null);
		}
	}
	
	@Override
	public ArrayList<FileDTO> fileList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<FileDTO> arr = new ArrayList<>();
		
		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from imagetest");
			
			while (rs.next()) {
				FileDTO f = new FileDTO();
				f.setImage(rs.getString("image"));
				f.setName(rs.getString("name"));
				f.setTitle(rs.getString("title"));
				arr.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	private void closeConnection(Connection con, PreparedStatement ps,
			 Statement st, ResultSet rs) {
			try {
				 if(con!=null)  con.close();
				 if(ps!=null)  ps.close();
				 if(st!=null)  st.close();
				 if(rs!=null)  rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	
}
