package academy.prog;

import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    static final String LOGIN = "admin";
    static final String PASS = "adminadmin";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        int age = ageValid(request.getParameter("age"));
        boolean pasValid = passValid(password);

        HttpSession session = request.getSession(true);
        if (LOGIN.equals(login) && PASS.equals(password) && age == 1 && pasValid == true) {

            session.setAttribute("user_login", login);

        } else if (LOGIN.equals(login) == false || PASS.equals(password) == false){
            session.setAttribute("log_pas", true);
        }
        session.setAttribute("pass_valid", pasValid);
        session.setAttribute("user_age", age);
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(a) && (session != null))
            session.removeAttribute("user_login");

        response.sendRedirect("index.jsp");
    }

    protected int ageValid (String age){
        int result = 0;
        try {
            if (age == null){
                result = 0;
            } else if (Integer.parseInt(age) >= 18){
                result = 1;
            } else if (Integer.parseInt(age) < 18){
                result = -1;
            }
        } catch (NumberFormatException e ){
            result = 0;
        }

        return result;
    }

    protected boolean passValid (String pass){
        boolean result = false;
        if (pass.length()>= 10){
            result = true;
        }
        return result;
    }
}


