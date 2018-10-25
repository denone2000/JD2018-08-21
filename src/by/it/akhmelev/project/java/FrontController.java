package by.it.akhmelev.project.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }


    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String command = req.getParameter("command");
        String view = "/error.jsp";
        switch (command) {
            case "Index":
                view = Actions.INDEX.jsp;
                break;
            case "Login":
                view = Actions.LOGIN.jsp;
                break;
            case "Logout":
                view = Actions.LOGOUT.jsp;
                break;
            case "SignUp":
                view = Actions.SIGNUP.jsp;
                break;
        }

        getServletContext().getRequestDispatcher(view).forward(req,resp);
    }
}
