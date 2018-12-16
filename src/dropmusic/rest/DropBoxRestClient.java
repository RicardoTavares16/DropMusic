package dropmusic.rest;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuthService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import uc.sd.apis.DropBoxApi2;

public class DropBoxRestClient {
	private static final String API_APP_KEY = "3fnl0xwmlv4o4ac";
	private static final String API_APP_SECRET = "3uvcl9l0t2pdo2u";

	private static final String API_USER_TOKEN = "";
	//vU8En2b_cPAAAAAAAAARf3pvxVP8v6ylaOhNorEEY38i5Vl8-1bj3M8aqnl_nSQe

	public static void main(String[] args) {
		OAuthService service = new ServiceBuilder()
		.provider(DropBoxApi2.class)
		.apiKey(API_APP_KEY)
		.apiSecret(API_APP_SECRET)
		.callback("https://eden.dei.uc.pt/~fmduarte/echo.php")
		.build();

		try {

			if ( API_USER_TOKEN.equals("") ) {
				System.out.println("Authorize scribe here:");
				System.out.println(service.getAuthorizationUrl(null));

				/*Desktop.getDesktop().browse(URI.create(service.getAuthorizationUrl(null)));

				URL url = new URL(service.getAuthorizationUrl(null));
				InputStream is = url.openStream();
				int ptr = 0;
				StringBuffer buffer = new StringBuffer();
				while ((ptr = is.read()) != -1) {
					buffer.append((char)ptr);
				}

				Document doc = Jsoup.parse(buffer.toString());
				System.out.println(doc.body().text());*/

				//@TODO: receber do html o código
				Verifier verifier = new Verifier("vU8En2b_cPAAAAAAAAARf3pvxVP8v6ylaOhNorEEY38i5Vl8-1bj3M8aqnl_nSQe");
				Token accessToken = service.getAccessToken(null, verifier);
				System.out.println("Define API_USER_TOKEN: " + accessToken.getToken());
				//System.out.println("Define API_USER_SECRET: " + accessToken.getSecret());
				System.exit(0);
			}

			Token accessToken = new Token( API_USER_TOKEN, "");

			listFiles(service, accessToken);

		} catch(OAuthException e) {
			e.printStackTrace();
		} /*catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

	private static void listFiles(OAuthService service, Token accessToken) {
		OAuthRequest request = new OAuthRequest(Verb.POST, "https://api.dropboxapi.com/2/files/list_folder", service);
		request.addHeader("authorization", "Bearer " + accessToken.getToken());
		request.addHeader("Content-Type",  "application/json");
		request.addPayload("{\n" + 
				"    \"path\": \"\",\n" + 
				"    \"recursive\": false,\n" + 
				"    \"include_media_info\": false,\n" + 
				"    \"include_deleted\": false,\n" + 
				"    \"include_has_explicit_shared_members\": false,\n" + 
				"    \"include_mounted_folders\": true\n" + 
				"}");
		
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println("HTTP RESPONSE: =============");
		System.out.println(response.getCode());
		System.out.println(response.getBody());
		System.out.println("END RESPONSE ===============");
		
		
		JSONObject rj = (JSONObject) JSONValue.parse(response.getBody());
		JSONArray contents = (JSONArray) rj.get("entries");
		for (int i=0; i<contents.size(); i++) {
			JSONObject item = (JSONObject) contents.get(i);
			String path = (String) item.get("name");
			System.out.println(" - " + path);
		}
	}

	
}
