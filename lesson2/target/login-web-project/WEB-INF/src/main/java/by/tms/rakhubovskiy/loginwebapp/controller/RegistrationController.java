package by.tms.rakhubovskiy.loginwebapp.controller;


import by.tms.rakhubovskiy.loginwebapp.entity.UserAccount;
import by.tms.rakhubovskiy.loginwebapp.repository.UserRepositoryImpl;
import by.tms.rakhubovskiy.loginwebapp.service.UserService;
import by.tms.rakhubovskiy.loginwebapp.service.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration_page")
public class RegistrationController extends HttpServlet {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = new UserServiceImpl(new UserRepositoryImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            getServletContext().getRequestDispatcher("/registration_page").forward(req, resp);
        } catch (ServletException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user_name = req.getParameter("username");
        String login = req.getParameter("login");
        String password = req.getParameter("pass");

        UserAccount userAccount = userService.findUser(login, password);

        if (userAccount == null){
            userService.addUser(user_name, login, password);
            resp.sendRedirect(req.getContextPath() + "/user_page.html");
        } else {
            String errorMessage = "Such user already exist";
            req.setAttribute("errorMessage", errorMessage);
            getServletContext().getRequestDispatcher("/registration_page.html").forward(req,resp);
            return;
        }
    }
}
