package co.sophy.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.common.Command;
import co.sophy.board.dao.BoardDao;
import co.sophy.board.vo.BoardVo;

public class BoardView implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// boardView.doó���ϴ� �޼ҵ�(�� �󼼺���)
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		
		vo=dao.select(vo);
		request.setAttribute("vo", vo);
		String viewPage=null;
		
		if(vo.getbId() > 0) {
			viewPage = "views/board/boardView.jsp";
		}
		return viewPage;
		
		
	}

}
