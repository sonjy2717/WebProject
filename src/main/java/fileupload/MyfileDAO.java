package fileupload;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

//DB 커넥션 풀을 통한 연결
public class MyfileDAO extends DBConnPool {
	
	//파일 및 게시물 입력
	public int insertFile(MyfileDTO dto) {
		int applyResult = 0;
		
		try {
			//1. 쿼리문 작성
			String query = "INSERT INTO management ( "
				+ " idx, img, name, to_char(price, '999,999,999'), "
				+ "	to_char(point, '999,999,999'), exp) "
				+ " VALUES ( "
				+ " ?, ?, ?, ?, ?, ?)";
			
			//2. 쿼리문 실행을 위한 객체 생성 및 인파라미터 설정
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getIdx());
			psmt.setString(2, dto.getImg());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getPrice());
			psmt.setString(5, dto.getPoint());
			psmt.setString(5, dto.getExp());
			
			//3. 쿼리 실행
			applyResult = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("INSERT 중 예외 발생");
			e.printStackTrace();
		}
		
		return applyResult;
	}
	
	//파일 목록 출력
	public List<MyfileDTO> myFileList() {
		List<MyfileDTO> fileList = new Vector<MyfileDTO>();
		
		//레코드를 일련번호의 내림차순으로 정렬
		String query = "SELECT * FROM management ORDER BY rownum DESC";
		
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			//ResultSet의 객체수 만큼 반복
			while (rs.next()) {
				MyfileDTO dto = new MyfileDTO();
				dto.setIdx(rs.getString(1));
				dto.setImg(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setPrice(rs.getString(4));
				dto.setPoint(rs.getString(5));
				dto.setExp(rs.getString(6));
				
				//각 레코드를 List컬렉션에 추가
				fileList.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println("SELECT 중 예외 발생");
			e.printStackTrace();
		}
		
		return fileList;
	}
}
