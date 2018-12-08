package rmi;

import dropmusic.auxfunc.Album;
import dropmusic.auxfunc.Music;
import java.rmi.Remote;
import java.util.List;

public interface RmiInterface extends Remote {
    public boolean login(String user, String pass, int id) throws java.rmi.RemoteException; //+

    public boolean registo(String user, String pass, int id) throws java.rmi.RemoteException;//+

    public boolean isEditor(String user, int id) throws java.rmi.RemoteException;

    public Boolean addMusic(String name, int id)  throws java.rmi.RemoteException;

    public Boolean addAlbum(String name, int id) throws java.rmi.RemoteException;

    public Boolean addArtist(String name, int id) throws java.rmi.RemoteException;

    public List<Album> getAlbuns(int id) throws java.rmi.RemoteException;

    public String getAlbumData(String x, int id) throws java.rmi.RemoteException;

    public String getArtistData(String x, int id) throws java.rmi.RemoteException;

    public Boolean editAlbumData(String user, String nomeAlbum, List<Music> musicList, int id) throws java.rmi.RemoteException;

    public Boolean editAlbumName(String user, String nomeAtual, String name, int id) throws java.rmi.RemoteException;

    public Boolean editAlbumDetails (String user, String nomeAlbum, String details, int id) throws java.rmi.RemoteException;

    public Boolean addReview(String user, String album, String review, int id) throws java.rmi.RemoteException;

    //public void pesquisaArtista(String s) throws java.rmi.RemoteException;

    //public void pesquisaAlbum(String s) throws java.rmi.RemoteException;

    public boolean makeEditor( String user1, String user2, int id) throws java.rmi.RemoteException; //+


}
