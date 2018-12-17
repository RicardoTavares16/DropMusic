package dropmusic.model;

import rmi.RmiInterface;
import dropmusic.auxfunc.stringFilter;

import javax.servlet.ServletException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Classe com os métodos de set e get auxiliares às funções de adição, estabelece ligação com o servidor RMI
 */
public class AddBean implements Serializable {
    public static final String SESSION_MAP_KEY = "addBean";
    private static final long serialVersionUID = 1L;

    private String musicToAdd;
    private String albumToAdd;
    private String artistToAdd;
    private int id;
    private RmiInterface rmiServer;

    /**
     * Construtor
     * Define o ID do cliente para as respostas multicast e estabelece a ligação com o servidor RMI
     * @throws Exception
     */
    public AddBean() throws Exception{
        try {
            id = (int) (Math.random() * 100);
            id = id * 2 + 1;
            rmiServer = (RmiInterface) Naming.lookup("XPTO");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new ServletException(e);
        }
    }

    /**
     * Set da musica a adicionar
     * @param musicToAdd
     */
    public void setMusicToAdd(String musicToAdd) {
        this.musicToAdd = stringFilter.filter(musicToAdd);
    }

    /**
     * Set do album a adicionar
     * @param albumToAdd
     */
    public void setAlbumToAdd(String albumToAdd) {
        this.albumToAdd = stringFilter.filter(albumToAdd);
    }

    /**
     * Set do artista a adicionar
     * @param artistToAdd
     */
    public void setArtistToAdd(String artistToAdd) {
        this.artistToAdd = stringFilter.filter(artistToAdd);
    }

    public String getMusicToAdd() {
        return musicToAdd;
    }

    public String getAlbumToAdd() {
        return albumToAdd;
    }

    public String getArtistToAdd() {
        return artistToAdd;
    }

    // Calls to RMI Server:

    /**
     * Função para adicionar musica, chama função correspondente do servidor RMI
     * @return true/false dependendo da resposta do servidor
     * @throws RemoteException
     */
    public boolean addMusic() throws RemoteException {
        return rmiServer.addMusic(musicToAdd, id);
    }

    /**
     * Função para adicionar album, chama função correspondente do servidor RMI
     * @return true/false dependendo da resposta do servidor
     * @throws RemoteException
     */
    public boolean addAlbum() throws RemoteException {
        return rmiServer.addAlbum(albumToAdd, id);
    }

    /**
     * Função para adicionar artista, chama função correspondente do servidor RMI
     * @return true/false dependendo da resposta do servidor
     * @throws RemoteException
     */
    public boolean addArtist() throws RemoteException {
        return rmiServer.addArtist(artistToAdd, id);
    }

}
