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
		map.put("/WriteNewBoard.do", new WriteNewBoardCommand()); //�۵��
		map.put("/boardView.do", new BoardView()); //�� �󼼺���
		map.put("/boardEdit.do", new BoardDeleteCommand()); //�� �󼼺���
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length()); //���� ��û��
		
		Command command = map.get(path); // ��û�Ѱ��� ó���ϴ� command�� ã���ش�. value���� �޾Ƽ�!
		String viewPage = command.excute(request, response); //ó���� �� ����� ������ page���� ����
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
