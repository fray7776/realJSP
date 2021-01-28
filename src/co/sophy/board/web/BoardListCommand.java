package co.sophy.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.common.Command;
import co.sophy.board.dao.BoardDao;
import co.sophy.board.vo.BoardVo;

public class BoardListCommand implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// List 가져오기
		BoardDao dao = new BoardDao();
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		list=dao.selectList();
		request.setAttribute("list", list);
		return "views/board/boardForm.jsp";
	}

}
