package dropmusic.rest;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuthService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import uc.sd.apis.DropBoxApi2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class DropboxConnection {
    private static final String API_APP_KEY = "3fnl0xwmlv4o4ac";
    private static final String API_APP_SECRET = "3uvcl9l0t2pdo2u";

    private static final String API_USER_TOKEN = "vU8En2b_cPAAAAAAAAARjxuNxfbfKMXMdCj7ytZ7Nhpk2hgzZmyy11HtAU6kgN1h";

    public static final String REDIRECT_URI = "http://localhost:8080/DropMusic/drophome";

    public String getDropboxAuthURL() {
        String dropboxURL = "";

        try {
            dropboxURL = "https://www.dropbox.com/1/oauth2/authorize?" + "client_id="
            + DropboxConnection.API_APP_KEY + "&response_type=code" + "&redirect_uri="
            + URLEncoder.encode(DropboxConnection.REDIRECT_URI, "UTF-8");

            System.out.println(dropboxURL);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return dropboxURL;
    }


    public ArrayList<String> getMusic() {
        ArrayList<String> tmp = new ArrayList<String>();


        OAuthService service = new ServiceBuilder()
                .provider(DropBoxApi2.class)
                .apiKey(API_APP_KEY)
                .apiSecret(API_APP_SECRET)
                .callback("https://eden.dei.uc.pt/~fmduarte/echo.php")
                .build();

        try{
            Token accessToken = new Token( API_USER_TOKEN, "");

            tmp = listFiles(service, accessToken);
        } catch(OAuthException e) {
            e.printStackTrace();
        }

        return tmp;
    }

    private static ArrayList<String> listFiles(OAuthService service, Token accessToken) {
        ArrayList<String> tmp = new ArrayList<String>();

        OAuthRequest request = new OAuthRequest(Verb.POST, "https://api.dropboxapi.com/2/files/list_folder", service);
        request.addHeader("authorization", "Bearer " + accessToken.getToken());
        request.addHeader("Content-Type",  "application/json");
        request.addPayload("{\n" +
                "    \"path\": \"/Apps/SDIntegration\",\n" +
                "    \"recursive\": false,\n" +
                "    \"include_media_info\": false,\n" +
                "    \"include_deleted\": false,\n" +
                "    \"include_has_explicit_shared_members\": false,\n" +
                "    \"include_mounted_folders\": true\n" +
                "}");

        Response response = request.send();
        //System.out.println("Got it! Lets see what we found...");
        //System.out.println("HTTP RESPONSE: =============");
        //System.out.println(response.getCode());
        //System.out.println(response.getBody());
        //System.out.println("END RESPONSE ===============");


        JSONObject rj = (JSONObject) JSONValue.parse(response.getBody());
        JSONArray contents = (JSONArray) rj.get("entries");
        for (int i=0; i<contents.size(); i++) {
            JSONObject item = (JSONObject) contents.get(i);
            String path = (String) item.get("name");
            System.out.println(" - " + path);
            tmp.add(path);
        }

        return tmp;
    }
}
