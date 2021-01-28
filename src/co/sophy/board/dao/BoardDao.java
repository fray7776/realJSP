package co.sophy.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import co.sophy.board.vo.BoardVo;

public class BoardDao extends DAO{
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<BoardVo> selectList() {
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		BoardVo vo;
		String sql = "SELECT* FROM BOARD ORDER BY BID DESC";
		
		try {
			psmt= conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new BoardVo();
				vo.setbId(rs.getInt("bid"));
				vo.setbName(rs.getString("bname"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				vo.setbGroup(rs.getInt("bgroup"));
				vo.setbStep(rs.getInt("bstep"));
				vo.setbIndent(rs.getInt("bindent"));
				list.add(vo);
				
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
		
	}
	
	public BoardVo select(BoardVo vo) {
		String sql = "SELECT* FROM BOARD WHERE BID=?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs=psmt.executeQuery();
			if(rs.next()) {
				vo.setbId(rs.getInt("bid"));
				vo.setbName(rs.getString("bname"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				vo.setbGroup(rs.getInt("bgroup"));
				vo.setbStep(rs.getInt("bstep"));
				vo.setbIndent(rs.getInt("bindent"));
				hitCount(vo.getbId()); //조회수 증가
			}
		}catch(SQLException e) {
		  e.printStackTrace();	
		}finally {
			close();
		}
		return vo;
		
	}
	
	public int insert(BoardVo vo) {
		int n = 0;
		String sql = "INSERT INTO BOARD VALUES(BIDSEQ.NEXTVAL,?,?,?,?,0,0,0,0)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbName());
			psmt.setString(2, vo.getbTitle());
			psmt.setString(3, vo.getbContent());
			psmt.setDate(4, vo.getbDate());
			n=psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int delete(BoardVo vo) {
		int n = 0;
		String sql = "DELETE FROM BOARD WHERE BID=?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			
			n=psmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int update(BoardVo vo) {
		int n = 0;
		String sql = "UPDATE BOARD SET BCONTENT=? WHERE BID=?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getbContent());
			psmt.setInt(2, vo.getbId());
			n=psmt.executeUpdate();

			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//hit 수 올리는 메소드 만들기
	
	private void hitCount(int hit) { //바깥에 보이지 않고 클래스 안에서만 쓸거니까 private
		String sql = "UPDATE BOARD SET BHIT= ?+ 1 WHERE BID=?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, hit);
		    psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
