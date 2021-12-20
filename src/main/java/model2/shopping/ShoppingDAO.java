package model2.shopping;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnect;

public class ShoppingDAO extends JDBConnect {
	
	//검색 조건에 맞는 게시물의 개수를 반환한다.
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		String query = "SELECT COUNT(*) FROM management";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		}
		catch (Exception e) {
			System.out.println("게시물 카운트 중 예외 발생");
			e.printStackTrace();
		}
		
		return totalCount;
	}
	
	public List<ManagementDTO> selectListPage(Map<String, Object> map) {
		List<ManagementDTO> board = new Vector<ManagementDTO>();
		
		String query = " "
				+ "SELECT * FROM "
				+ "    ( SELECT Tb.*, ROWNUM rNum FROM "
				+ "        ( SELECT idx, img, name, to_char(price, '999,999,999'), "
				+ "        to_char(point, '999,999,999'), exp FROM management ORDER BY idx DESC ) Tb ) "
				+ " WHERE rNum BETWEEN ? AND ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				ManagementDTO dto = new ManagementDTO();
				
				dto.setIdx(rs.getString(1));
				dto.setImg(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setPrice(rs.getString(4));
				dto.setPoint(rs.getString(5));
				dto.setExp(rs.getString(6));
				
				board.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		
		return board;
	}
	
	//주어진 이름에 해당하는 게시물을 DTO에 담아 반환한다.
	public ManagementDTO selectView(String idx) {
		ManagementDTO dto = new ManagementDTO(); //DTO 객체 생성
		String query = "SELECT idx, img, name, to_char(price, '999,999,999'), "
				+ " to_char(point, '999,999,999'), exp FROM management "
				+ " WHERE idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			if (rs.next()) { //결과를 DTO에 저장
				dto.setIdx(rs.getString(1));
				dto.setImg(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setPrice(rs.getString(4));
				dto.setPoint(rs.getString(5));
				dto.setExp(rs.getString(6));
			}
		}
		catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		
		return dto;
	}
}
