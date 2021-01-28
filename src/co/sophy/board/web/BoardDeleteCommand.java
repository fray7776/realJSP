package co.sophy.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.common.Command;
import co.sophy.board.dao.BoardDao;
import co.sophy.board.vo.BoardVo;

public class BoardDeleteCommand implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// boardDelete.do 처리 메소드
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		
		request.setAttribute("vo", vo);
		int n=dao.delete(vo);
		String viewPage=null;
		if(n==0)
			viewPage="views/board/boardView.jsp";
		
		return viewPage;
	}

}
