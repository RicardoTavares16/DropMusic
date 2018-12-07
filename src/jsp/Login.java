package jsp;

import rmi.RmiInterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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

    private RmiInterface rmiServer;

    @Override
    public void init() throws ServletException {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            rmiServer = (RmiInterface) registry.lookup("XPTO");
        } catch (AccessException e) {
            throw new ServletException(e);
        } catch (RemoteException e) {
            throw new ServletException(e);
        } catch (NotBoundException e) {
            throw new ServletException(e);
        }
    }

    /*public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String un = request.getParameter("username");
        String pw = request.getParameter("password");

        if (database.containsKey(un) && database.get(un).equals(pw)) {
            request.getSession().setAttribute("user", new Person(un, pw, false));
        }

        request.getRequestDispatcher("/login/index.jsp").forward(request, response);


    }*/

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Entrou no doG0t");

        rmiServer.login("tintin", "unicorn", 2);
        writer.flush();
    }
}
