package jsp;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/login/Login" })
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static HashMap<String, String> database = new HashMap<>();

    static {
        database.put("tom", "cat");
        database.put("scooby", "doo");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String un = request.getParameter("username");
        String pw = request.getParameter("password");

        if (database.containsKey(un) && database.get(un).equals(pw)) {
            request.getSession().setAttribute("user", new Person(un, pw, false));
        }

        request.getRequestDispatcher("/login/index.jsp").forward(request, response);
    }
}
