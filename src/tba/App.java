package tba;
import static tba.Constants.TBAConstants.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.Gson;
//import com.google.gson.JsonObject;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Testing TBA Read API V3...");

        Gson gson = new Gson();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What do you want to search for?");
        String input = keyboard.next();
        String testVar = createEndpoint(input);
        System.out.println("Creating HttpRequest...");
        keyboard.close();



        //use "builder" pattern to craft request
        HttpRequest getRequest = HttpRequest.newBuilder()
            .uri(new URI(testVar))
            .header("X-TBA-Auth-Key", kAPIKey)
            .build();

        //Now we need something to actually send the request
        HttpClient httpClient = HttpClient.newHttpClient();
        System.out.println(getRequest.toString());
        //"BodyHandlers.ofString" just tells the API that we want the response in the form of a String
        HttpResponse<String> getResponse =  httpClient.send(getRequest, BodyHandlers.ofString());

        //zooo wee mamma it works
        System.out.println(getResponse.body());
        
    }

    public static void makeQuery(){
        System.out.println("TBA Read API v3");
        System.out.println("What do you want to search for?");

    }

    public static String createEndpoint(String target){
        System.out.println(kEndpointStarter+target);
        return kEndpointStarter+target;
    }
}
