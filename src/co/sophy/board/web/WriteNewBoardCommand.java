package co.sophy.board.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.common.Command;
import co.sophy.board.dao.BoardDao;
import co.sophy.board.vo.BoardVo;

public class WriteNewBoardCommand implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// memberJoin.do 처리 메소드
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setbName(request.getParameter("bName"));
		vo.setbDate(Date.valueOf(request.getParameter("bDate")));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		
		request.setAttribute("vo", vo);
		int n=dao.insert(vo);
		
		String viewPage = null;
		
		if(n > 0) {
			viewPage = "views/board/boardForm.jsp";
		}
		
		return viewPage;
	}

}
