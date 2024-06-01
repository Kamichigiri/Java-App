package javaoop;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
import java.nio.channels.UnresolvedAddressException;
import com.google.gson.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class WrapperService {

    private static final String REGISTER_TOKEN = "Bearer dae24589d30aebdb50530d5debdd85027303bf58fc858d195d9ffbcc5d5f6823";
    private static final Path FILE_PATH = Path.of("C:\\Users\\onojaaa\\Documents\\Dev\\filename.txt");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static String jsonResponse;

    public void getStatusApi() {
        sendRequest("https://simple-tool-rental-api.glitch.me", "GET", "Get Status", null);
    }

    public void getToolsApi() {
        sendRequest("https://simple-tool-rental-api.glitch.me/tools", "GET", "Get Tools", null);
    }

    public static void placeOrderApi(String ID,String Name, String Comment) {
        String jsonBody = "{\"toolId\":\"" + ID + "\", \"customerName\": \"" + Name + "\",  \"comment\":\"" + Comment + "\"}";
        sendRequest("https://example.com/api", "POST", "Place Order", jsonBody);
    }

    public void registerApi(String clientName, String clientEmail) {
        String jsonBody = "{\"clientName\":\"" + clientName + "\", \"clientEmail\":\"" + clientEmail + "\"}";
        sendRequest("https://simple-tool-rental-api.glitch.me/api-clients", "POST", "Register", jsonBody);
    }

    public static void getToolsById(int ID ){
        sendRequest("https://simple-tool-rental-api.glitch.me/tools/:" + ID, "GET", "Get Tools By Id", null);
//        Tools tool = new Tools();
        Gson gson = new Gson();
        try {
            System.out.println(gson.fromJson(jsonResponse, Tools.class));
        } catch (Exception e) {
            System.out.println(e.getMessage()); // handle exception
        }
    }

    public static void deleteOrder(int ID ){
        sendRequest("https://simple-tool-rental-api.glitch.me/orders/:" + ID, "DELETE", "Delete Order", null);
    }



    private static void sendRequest(String url, String method, String requestName, String jsonBody) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json").header("Autorization", REGISTER_TOKEN);

        if ("POST".equalsIgnoreCase(method) && jsonBody != null) {
            requestBuilder.POST(HttpRequest.BodyPublishers.ofString(jsonBody));
        } else if("GET".equalsIgnoreCase(method)){
            requestBuilder.GET();
        }else{
            requestBuilder.DELETE();
        }

        HttpRequest request = requestBuilder.build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            jsonResponse = response.body();
            logToFile(method + requestName + " Request::: ", request.bodyPublisher().toString());
            logToFile(method + " Response::: ", response.statusCode() + " " + response.body());
        } catch (IOException | InterruptedException | UnresolvedAddressException e) {
            e.printStackTrace();
        }
    }

    private static void logToFile(String title, String content) {
        try {
            if (!Files.exists(FILE_PATH)) {
                Files.createFile(FILE_PATH);
            }

            String logEntry = DATE_TIME_FORMATTER.format(LocalDateTime.now()) + " " + title + "\n" + content + "\n";
            Files.writeString(FILE_PATH, logEntry, StandardOpenOption.APPEND);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
