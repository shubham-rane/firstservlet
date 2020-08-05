package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginUtility;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Login login = new Login(username,password);
		LoginUtility lg = new LoginUtility();
		PrintWriter pw = resp.getWriter();
		if(lg.validate(login)) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			pw.println("Login failed");
		}
	}
	
}
