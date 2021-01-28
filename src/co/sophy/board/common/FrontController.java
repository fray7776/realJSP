package co.sophy.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.web.BoardDeleteCommand;
import co.sophy.board.web.BoardListCommand;
import co.sophy.board.web.BoardView;
import co.sophy.board.web.MainCommand;
import co.sophy.board.web.NewBoardCommand;
import co.sophy.board.web.WriteNewBoardCommand;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();
    
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/selectList.do", new BoardListCommand());
		map.put("/newBoard.do", new NewBoardCommand());
		map.put("/WriteNewBoard.do", new WriteNewBoardCommand()); //글등록
		map.put("/boardView.do", new BoardView()); //글 상세보기
		map.put("/boardEdit.do", new BoardDeleteCommand()); //글 상세보기
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length()); //실제 요청값
		
		Command command = map.get(path); // 요청한것을 처리하는 command를 찾아준다. value값을 받아서!
		String viewPage = command.excute(request, response); //처리한 후 결과를 돌려줄 page값을 받음
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
