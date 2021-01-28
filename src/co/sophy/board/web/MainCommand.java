package co.sophy.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.common.Command;

public class MainCommand implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// main.do 요청 처리
		
		return "views/main/main.jsp";
	}

}
