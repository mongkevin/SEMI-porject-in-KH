package com.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Location;
import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.pageInfo;

public class BoardService {
	Connection conn = JDBCTemplate.getConnection();
	public int selectListCount() {
		
		int listCount = new BoardDao().selectListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	public ArrayList<Board> selectList(pageInfo pi) {
		
		ArrayList<Board> list = new BoardDao().selectList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list ;
	}

	public ArrayList<Location> selectLocation() {
		
		ArrayList<Location> list = new BoardDao().selectLocation(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertBoard(Board b, Attachment at) {
		
		int result = new BoardDao().insertBoard(conn,b);
		
		int result2 =1;
		
		if(at!=null) {
			result2 = new BoardDao().insertAttachment(conn,at);
		}
		
		if(result>0&&result2>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		
		return result*result2;
	}

	public int increaseCount(int bno) {
		
		int result = new BoardDao().increaseCount(conn, bno);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public Board selectBoard(int bno) {
		Board b = new BoardDao().selectBoard(conn,bno);
		
		JDBCTemplate.close(conn);
		return b;
	}

	public Attachment selectAttachment(int bno) {
		Attachment at = new BoardDao().selectAttachment(conn, bno);
		
		JDBCTemplate.close(conn);
		return at;
	}
}
