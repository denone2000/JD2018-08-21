package by.it.galushka.project.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String command = req.getParameter("command");
        String view = "/error.jsp";
        switch (command) {
            case "Index":
                view = Action.INDEX.jsp;
                break;
            case "Login":
                view = Action.LOGIN.jsp;
                break;
            case "Logout":
                view = Action.LOGOUT.jsp;
                break;
            case "SignUp":
                view = Action.SIGNUP.jsp;
                break;
        }
        getServletContext().getRequestDispatcher(view).forward(req, resp);
    }
}
