package dropmusic.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DropboxConnection {
    private static final String API_APP_KEY = "3fnl0xwmlv4o4ac";
    private static final String API_APP_SECRET = "3uvcl9l0t2pdo2u";
    private static final String API_USER_TOKEN = "";

    public static final String REDIRECT_URI = "http://localhost:8080/DropMusic/drophome";

    public String getDropboxAuthURL() {
        String dropboxURL = "";

        try {
            dropboxURL = "http://api.dropboxapi.com/2/oauth?" + "client_id="
            + DropboxConnection.API_APP_KEY + "&redirect_uri="
            + URLEncoder.encode(DropboxConnection.REDIRECT_URI, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return dropboxURL;
    }
}
