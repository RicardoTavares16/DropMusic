package dropmusic.model;

import dropmusic.auxfunc.stringFilter;
import rmi.RmiInterface;

import javax.servlet.ServletException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Classe com os métodos de set e get auxiliares às funções de Login e Registo, estabelece ligação com o servidor RMI
 */
public class PersonBean implements Serializable {
    public static final String SESSION_MAP_KEY = "PersonBean";
    private static final long serialVersionUID = 1L;

    RmiInterface rmiServer;

    private String username;
    private String password;
    private int id;
    private boolean editor;

    private String user1, user2;

    /**
     * Construtor
     * Define o ID do cliente para as respostas multicast e estabelece a ligação com o servidor RMI
     * @throws Exception
     */
    public PersonBean() throws Exception{
        try {
            id = (int) (Math.random() * 100);
            id = id * 2 + 1;
            System.out.println("RMI");
            rmiServer = (RmiInterface) Naming.lookup("XPTO");
            System.out.println(rmiServer);
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new ServletException(e);
        }
    }

    /**
     * Método para verificar o Login, chama função correspondente do Servidor RMI
     * @return true/false dependendo da resposta do servidor
     */
    public boolean getLogin() throws RemoteException {
        return rmiServer.login(username, password, id);
    }

    /**
     * Método para verificar o Registo, chama função correspondente do Servidor RMI
     * @return true/false dependendo da resposta do servidor
     */
    public boolean getReg() throws RemoteException {
        return rmiServer.registo(username, password, id);
    }

    /**
     * Método para verificar o se o utilizador é um editor, chama função correspondente do Servidor RMI
     * @return true/false dependendo da resposta do servidor
     */
    public boolean getIsEditor() throws RemoteException {
        return rmiServer.isEditor(this.username, id);
    }

    /**
     * Método para tornar o utilizador num editor, chama função correspondente do Servidor RMI
     * user1, chama a função como 1º argumento para verificar se este é utilizador
     * user2, quem vai passar a editor
     * @return true/false dependendo da resposta do servidor
     */
    public boolean getMakeEditor() throws RemoteException {
        return rmiServer.makeEditor(user1, user2, id);
    }

    //Pares set/get
    public void setUsername(String username) {
        this.username = stringFilter.filter(username);
    }
    public void setPassword(String password) {
        this.password = stringFilter.filter(password);
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }

    public boolean getEditor() { return this.editor; }
    public void setEditor(boolean editor) { this.editor = editor; }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public void setUser2(String user2) {
        this.user2 = stringFilter.filter(user2);
    }

    /**
     * Lista a informação de um utilizador
     * @return String com username, password e se é editor
     */
    @Override
    public String toString() {
        return "PersonBean [username=" + username + ", password=" + password + ", editor=" + editor + "]";
    }

}
