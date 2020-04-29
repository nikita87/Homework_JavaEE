package by.tms.rakhubovskiy.loginwebapp.controller;

import by.tms.rakhubovskiy.loginwebapp.entity.UserAccount;
import by.tms.rakhubovskiy.loginwebapp.repository.UserRepositoryImpl;
import by.tms.rakhubovskiy.loginwebapp.service.UserService;
import by.tms.rakhubovskiy.loginwebapp.service.UserServiceImpl;
import by.tms.rakhubovskiy.loginwebapp.utils.AppUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

    private final UserService userService;

    public LoginController() {
        this.userService = new UserServiceImpl(new UserRepositoryImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user_name = req.getParameter("username");
        String password = req.getParameter("pass");
        UserAccount userAccount = userService.findUser(user_name, password);

        if(userAccount == null){
            String errorMessage = "invalid Login or Password";
            req.setAttribute("errorMessage", errorMessage);
            getServletContext().getRequestDispatcher("/registration_page.html").forward(req,resp);
            return;
        }
        AppUtils.storeLoginedUser(req.getSession(), userAccount);

        int redirectId = -1;

        try{
            redirectId = Integer.parseInt(req.getParameter("redirectId"));
        }catch (Exception e){

        }

        String requestUri = AppUtils.getRedirectAfterLoginUrl(req.getSession(), redirectId);
        if(requestUri != null){
            resp.sendRedirect(requestUri);
        } else {
            resp.sendRedirect(req.getContextPath() + "/user_page.html");
        }
    }
}

