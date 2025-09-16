package com.test.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.util.DBUtil;

public class AjaxDAO {

	private DBUtil util;
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public AjaxDAO() {
		try {
			util = new DBUtil();
			conn = util.open();
			stat = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SurveyDTO getSurvey(int seq) {
		
		try {
			
			String sql = "select * from tblSurvey where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seq);
			
			rs = pstat.executeQuery();
			
			SurveyDTO dto = new SurveyDTO();
			
			if (rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setQuestion(rs.getString("question"));
				dto.setItem1(rs.getString("item1"));
				dto.setItem2(rs.getString("item2"));
				dto.setItem3(rs.getString("item3"));
				dto.setItem4(rs.getString("item4"));
				dto.setCnt1(rs.getInt("cnt1"));
				dto.setCnt2(rs.getInt("cnt2"));
				dto.setCnt3(rs.getInt("cnt3"));
				dto.setCnt4(rs.getInt("cnt4"));
				
				return dto;				
			}
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.getSurvey()");
			e.printStackTrace();
		}
		
		return null;
	}

	public String getInsa(String num3) {
		
		try {
			
			String sql = "select name from tblInsa where num = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, num3);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getString("name");
			}
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.getInsa()");
			e.printStackTrace();
		}
		
		return null;
	}

	public int checkId(String id) {
		
		try {
			
			String sql = "select count(*) as cnt from tblUser where id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt"); //1, 0
			}
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.checkId()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
public ArrayList<ZipCodeDTO> listZipCode(String dong) {
		
		try {
			
			String sql = "select * from zipcode"
							+ " where dong like '%' || ? || '%'";
							
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dong);
			
			rs = pstat.executeQuery();
			
			ArrayList<ZipCodeDTO> list = new ArrayList<ZipCodeDTO>();
			
			while (rs.next()) {
				//레코드 1줄 > DTO 1개
				ZipCodeDTO dto = new ZipCodeDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSido(rs.getString("sido"));
				dto.setGugun(rs.getString("gugun"));
				dto.setDong(rs.getString("dong"));
				dto.setBunji(rs.getString("bunji"));
				dto.setZipcode(rs.getString("zipcode"));
				
				list.add(dto);						
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<UserDTO> getUsers() {
		
		try {
			
			String sql = "select * from tblUser";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			List<UserDTO> list = new ArrayList<UserDTO>();
			
			while (rs.next()) {
				
				//레코드 1줄 > DTO 1개
				UserDTO dto = new UserDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGrade(rs.getString("grade"));
				
				list.add(dto);	
			}
			
			return list;			
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.getUsers()");
			e.printStackTrace();
		}
		
		return null;
	}

	public List<AddressDTO> addressList() {
		
		try {
			
			String sql = "select * from tblAddress order by seq desc";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			List<AddressDTO> list = new ArrayList<AddressDTO>();
			
			while (rs.next()) {
				
				//레코드 1줄 > DTO 1개
				AddressDTO dto = new AddressDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.addressList()");
			e.printStackTrace();
		}
		
		return null;
	}

	public int addAddress(AddressDTO dto) {
		
		try {
			
			String sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getAge());
			pstat.setString(3, dto.getGender());
			pstat.setString(4, dto.getTel());
			pstat.setString(5, dto.getAddress());
			
			return pstat.executeUpdate();			
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.addAddress()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public String getAddressSeq() {
		
		try {
			
			String sql = "select max(seq) as seq from tblAddress";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getString("seq");
			}
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.getAddressSeq()");
			e.printStackTrace();
		}
		
		return null;
	}

	public void editCat(CatDTO dto) {
		
		try {
			
			String sql = "update tblCat set x = ?, y = ? where catid = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getX());
			pstat.setString(2, dto.getY());
			pstat.setString(3, dto.getId());
			
			pstat.executeQuery();
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.editCat()");
			e.printStackTrace();
		}
		
	}

	public CatDTO getCat(String id) {
		
		try {
			
			String sql = "select * from tblCat where catid = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				CatDTO dto = new CatDTO();
				
				dto.setId(rs.getString("catid"));
				dto.setX(rs.getString("x"));
				dto.setY(rs.getString("y"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.getCat()");
			e.printStackTrace();
		}
		
		return null;
	}

}
















