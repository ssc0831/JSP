package com.jqueryAddress;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JAddressDAOImpl implements JAddressDAO {

	private static JAddressDAO instance;

	public static JAddressDAO getInstance() {
		if (instance == null) {
			instance = new JAddressDAOImpl();
		}
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}

	@Override
	public void insert(AddressVO avo) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			String sql = "insert into address values(address_seq.nextval,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, avo.getName());
			ps.setString(2, avo.getZipcode());
			ps.setString(3, avo.getAddr());
			ps.setString(4, avo.getTel());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}

	}

	@Override
	public ArrayList<AddressVO> list() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<AddressVO> arr = new ArrayList<>();

		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select * from address order by num asc";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				AddressVO avo = new AddressVO();
				avo.setAddr(rs.getString("addr"));
				avo.setName(rs.getString("name"));
				avo.setNum(rs.getInt("num"));
				avo.setTel(rs.getString("tel"));
				avo.setZipcode(rs.getString("zipcode"));
				arr.add(avo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override
	public AddressVO findByNum(int num) {
		String sql = "select * from address where num="+num;
		AddressVO avo = new AddressVO();
		try{Connection con = getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				avo.setAddr(rs.getString("addr"));
				avo.setName(rs.getString("name"));
				avo.setNum(rs.getInt("num"));
				avo.setTel(rs.getString("tel"));
				avo.setZipcode(rs.getString("zipcode"));
				}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		return avo;
	}

	@Override
	public void update(AddressVO avo) {
		Connection con = null;
		PreparedStatement ps= null;
		
		try {
			con = getConnection();
			String sql="update address set name=?, "
					+ "zipcode=?,tel=?, addr=? where num=?";
			ps= con.prepareStatement(sql);
			ps.setString(1, avo.getName());
			ps.setString(2, avo.getZipcode());
			ps.setString(3, avo.getTel());
			ps.setString(4, avo.getAddr());
			ps.setInt(5, avo.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
     		e.printStackTrace();
		}finally {
			closeConnection(con, ps, null, null);
		}
	}
		

	@Override
	public void delete(int num) {
		Connection con = null;
		Statement st = null;
		try {
			con = getConnection();
			String sql = "delete from address where num="+num;
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			closeConnection(con, null, st, null);
		}
	}


	@Override
	public int getCount() {
		int count = 0;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "select count(*) from address";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}

		return count;
	}

	@Override
	public int getCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "";
		int count = 0;

		try {
			con = getConnection();
			if (word.equals("")) {
				sql = "select count(*) from address";
			} else {
				sql = "select count(*) from address where " + field + " like '%" + word + "%'";
			}
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return count;
	}

	@Override
	public ArrayList<AddressVO> searchList(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<AddressVO> arr = new ArrayList<>();

		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select * from address where " + field + " like '%" + word + "%'";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				AddressVO avo = new AddressVO();
				avo.setAddr(rs.getString("addr"));
				avo.setName(rs.getString("name"));
				avo.setNum(rs.getInt("num"));
				avo.setTel(rs.getString("tel"));
				avo.setZipcode(rs.getString("zipcode"));
				arr.add(avo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override
	public ArrayList<ZipCodeVO> getZipcode(String dong) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipCodeVO> zarr = new ArrayList<>();
		try {
			con = getConnection();
			String sql = "select * from zipcode where dong like '%" + dong + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ZipCodeVO zip = new ZipCodeVO();
				zip.setBunji(rs.getString("bunji"));
				zip.setDong(rs.getString("dong"));
				zip.setGugun(rs.getString("gugun"));
				zip.setSido(rs.getString("sido"));
				zip.setZipcode(rs.getString("zipcode"));
				zarr.add(zip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}

		return zarr;
	}

	private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
		try {
			if (con != null)
				con.close();
			if (ps != null)
				ps.close();
			if (st != null)
				st.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
