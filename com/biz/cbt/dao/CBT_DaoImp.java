package com.biz.cbt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.cbt.vo.CBT_VO;
import com.biz.cbt.vo.CBT_VO_02;

public class CBT_DaoImp implements CBT_Dao{

	Connection dbConn;
	
	public CBT_DaoImp() {
		this.dbConnection();
	}
	
	private void dbConnection() {
		String dbDriver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(dbDriver);
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "EIP";
			String password = "1234";
			
			dbConn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<CBT_VO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_CBT ";
		sql += " ORDER BY cb_id ";
		
		PreparedStatement ps;
		try {
			ps = dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<CBT_VO> cList = new ArrayList();

			
			while(rs.next()) {
				long id = rs.getLong("cb_id");
				String strQue = rs.getString("cb_que");
				String strFir = rs.getString("cb_fir");
				String strSec = rs.getString("cb_sec");
				String strThi = rs.getString("cb_thi");
				String strFou = rs.getString("cb_fou");
				int intAns = rs.getInt("cb_ans");
				
				CBT_VO cvo = new CBT_VO();
				cvo.setId(id);
				cvo.setCb_que(strQue);
				cvo.setCb_fir(strFir);
				cvo.setCb_sec(strSec);
				cvo.setCb_thi(strThi);
				cvo.setCb_fou(strFou);
				cvo.setCb_ans(intAns);
				
				
				cList.add(cvo);
				
			}
			rs.close();
			return cList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void insert(CBT_VO_02 cbvo) {
		// TODO Auto-generated method stub
		long id_02 = cbvo.getId_02();
		String que = cbvo.getCb_que_02();
		String fir = cbvo.getCb_fir_02();
		String sec = cbvo.getCb_sec_02();
		String thi = cbvo.getCb_thi_02();
		String fou = cbvo.getCb_fou_02();
		int ans = cbvo.getCb_ans_02();
		String strAns = String.valueOf(ans);
		
		String sql = " INSERT INTO tbl_cbt ";
		sql += " VALUES('" + id_02 + "', ";
		sql += " '" + que + "', '" + fir + "', ";
		sql += " '" + sec + "', '" + thi + "', ";
		sql += " '" + fou + "', '" + strAns + "' ";
		sql += " ) ";
		
		sql += " INSERT INTO tbl_cbt ";
		sql += " VALUES(?, ?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement ps;
		try {
			ps = dbConn.prepareStatement(sql);
			ps.setLong(1, id_02);
			ps.setString(2, que);
			ps.setString(3, fir);
			ps.setString(4, sec);
			ps.setString(5, thi);
			ps.setString(6, fou);
			ps.setInt(7, ans);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void update(CBT_VO_02 cbvo) {
		// TODO Auto-generated method stub
		String sql = " UPDATE tbl_cbt ";
		sql += " SET cb_id = ?, ";
		sql += " cb_que = ?, ";
		sql += " cb_fir = ?, ";
		sql += " cb_sec = ?, ";
		sql += " cb_thi = ?, ";
		sql += " cb_fou = ?, ";
		sql += " cb_ans = ? ";
		sql += " WHERE cb_id = ? ";
		
		PreparedStatement ps;
		try {
			ps = dbConn.prepareStatement(sql);
			ps.setLong(1, cbvo.getId_02());
			ps.setString(2, cbvo.getCb_que_02());
			ps.setString(3, cbvo.getCb_fir_02());
			ps.setString(4, cbvo.getCb_sec_02());
			ps.setString(5, cbvo.getCb_thi_02());
			ps.setString(6, cbvo.getCb_fou_02());
			ps.setInt(7, cbvo.getCb_ans_02());
			ps.setLong(8, cbvo.getId_02());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(long id_02) {
		// TODO Auto-generated method stub
		String sql = " DELETE FROM tbl_cbt ";
		sql += " WHERE cb_id = ? ";
		PreparedStatement ps;
		
		try {
			ps = dbConn.prepareStatement(sql);
			ps.setLong(1, id_02);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public CBT_VO_02 findById(long id_02) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_cbt ";
		sql += " WHERE cb_id = ? ";
		
		PreparedStatement ps;
		
		try {
			ps = dbConn.prepareStatement(sql);
			ps.setLong(1, id_02);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			CBT_VO_02 cbvo = new CBT_VO_02();
			cbvo.setId_02(rs.getLong("cb_id"));
			cbvo.setCb_que_02(rs.getString("cb_que"));
			cbvo.setCb_fir_02(rs.getString("cb_fir"));
			cbvo.setCb_sec_02(rs.getString("cb_sec"));
			cbvo.setCb_thi_02(rs.getString("cb_thi"));
			cbvo.setCb_fou_02(rs.getString("cb_fou"));
			cbvo.setCb_ans_02(rs.getInt("cb_ans"));

			return cbvo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}