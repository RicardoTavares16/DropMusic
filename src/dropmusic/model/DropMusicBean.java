package dropmusic.model;

import dropmusic.auxfunc.Music;
import dropmusic.auxfunc.stringFilter;
import rmi.RmiInterface;

import javax.servlet.ServletException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe com os métodos de set e get auxiliares às funções de Pesquisa, Edição e Remoção, estabelece ligação com o servidor RMI
 */
public class DropMusicBean implements Serializable {
    public static final String SESSION_MAP_KEY = "dropMusicBean";

    private RmiInterface rmiServer;
    private int id;
    private String name;

    // To search:
    private String albumName;
    private String artistName;

    //To show:
    private String toShow;

    // To Review:
    private String review;
    private int points;
    private String user;

    // To edit:
    private String newName;
    private String newDetails;
    private List<Music> newList = Collections.synchronizedList(new ArrayList<Music>());

    /**
     * Construtor
     * Define o ID do cliente para as respostas multicast e estabelece a ligação com o servidor RMI
     * @throws Exception
     */
    public DropMusicBean() throws Exception {
        try {
            System.out.println("Creating RMI Connection...");
            id = (int) (Math.random() * 100);
            id = id * 2 + 1;
            rmiServer = (RmiInterface) Naming.lookup("XPTO");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new ServletException(e);
        }
    }

    //Pares set/get
    public void setName(String name) {
        this.name = stringFilter.filter(name);
    }

    public String getName() {
        return this.name;
    }

    public void setAlbumName(String albumName) {
        this.albumName = stringFilter.filter(albumName);
    }

    public void setReview(String review) {
        this.review = stringFilter.filter(review);
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setUser(String user) {
        this.user = stringFilter.filter(user);
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public void setArtistName(String artistName) {
        this.artistName = stringFilter.filter(artistName);
    }

    public String getArtistName() {
        return this.artistName;
    }

    public void setToShow(String toShow) {
        this.toShow = toShow;
    }

    public String getToShow() {
        return this.toShow;
    }

    public void setNewName(String newName) {
        this.newName = stringFilter.filter(newName);
    }

    public void setNewDetails(String newDetails) {
        this.newDetails = stringFilter.filter(newDetails);
    }

    // Calls to RMI Server:

    /**
     * Função para obter as músicas de um álbum
     * @return String com as músicas, filtrada pela função de parsing
     * @throws RemoteException
     */
    public String getGetAlbumData() throws RemoteException { // @TODO: parse para colocar isto bonito?
        System.out.println("Getting album data...");
        this.toShow = stringFilter.filterReverse(rmiServer.getAlbumData(this.albumName, this.id));

        return this.toShow;
    }

    /**
     * Função para obter os dados de um artista
     * @return String com os dados, filtrada pela função de parsing
     * @throws RemoteException
     */
    public String getGetArtistData() throws RemoteException {
        System.out.println("Getting artist data...");
        this.toShow = stringFilter.filterReverse(rmiServer.getArtistData(this.artistName, this.id));

        this.artistName = null;

        return this.toShow;
    }

    /**
     * Função para obter todos os álbuns
     * @return Lista com os nomes dos álbuns
     * @throws RemoteException
     */
    public ArrayList<String> getGetAlbuns() throws RemoteException {
        return rmiServer.getAlbuns(this.id);
    }

    /**
     * Função para obter todos os detalhes de um álbum (criticas etc)
     * @return Lista com os detalhes
     * @throws RemoteException
     */
    public ArrayList<String> getGetAlbumDetails() throws RemoteException {
        return rmiServer.getAlbumDetails(this.id);
    }

    /**
     * Função para adicionar uma review a um álbum
     * @return true/false dependendo da resposta do RMI
     * @throws RemoteException
     */
    public Boolean getAddReview() throws RemoteException {
        return rmiServer.addReview(this.user, this.albumName, this.review + "*" + this.points, this.id);
    }

    /**
     * Função para editar o nome de um álbum
     * @return true/false dependendo da resposta do RMI
     * @throws RemoteException
     */
    public Boolean getEditAlbumName() throws RemoteException {
        return rmiServer.editAlbumName(this.user, this.albumName, this.newName, this.id);
    }

    /**
     * Função para editar os detalhes de um álbum
     * @return true/false dependendo da resposta do RMI
     * @throws RemoteException
     */
    public Boolean getEditAlbumDetails() throws RemoteException {
        return rmiServer.editAlbumDetails(this.user, this.albumName, this.newDetails, this.id);
    }

    /**
     * Função para remover um artista
     * @return true/false dependendo da resposta do RMI
     * @throws RemoteException
     */
    public boolean getRemoveArtist() throws RemoteException {
        return rmiServer.removeArtist(this.id);
    }

    /**
     * Função para editar as músicas de um álbum
     * @return true/false dependendo da resposta do RMI
     * @throws RemoteException
     */
    // @TODO: implementar nas struts
    public boolean getEditAlbumData() throws RemoteException {
        return rmiServer.editAlbumData(this.user, this.albumName, this.newList, this.id);
    }
}
