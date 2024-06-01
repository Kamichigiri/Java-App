package javaoop;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
import java.nio.channels.UnresolvedAddressException;
//import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class GetTools {

    // Variables and Objects used
    String registerToken = "Bearer dae24589d30aebdb50530d5debdd85027303bf58fc858d195d9ffbcc5d5f6823";
    String jsonResponse;


    public void getStatusApi(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://simple-tool-rental-api.glitch.me"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        System.out.println(request.headers());
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());

            try {
                File myObj = new File("C:\\Users\\onojaaa\\Documents\\Dev\\filename.txt");
                if (myObj.createNewFile()) {
                  System.out.println("File created: " + myObj.getName());
                } else {
                  System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            try {
                FileWriter myWriter = new FileWriter("C:\\Users\\onojaaa\\Documents\\Dev\\filename.txt", true);
                myWriter.write(dtf.format(now) + "\nGet Status Request:::");
                myWriter.write(" " + request.bodyPublisher() + "\n");
                myWriter.write(dtf.format(now) + "\nGet Status Response::: ");
                myWriter.write(response.statusCode() + " ");
                myWriter.write(response.body() + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        } catch (IOException | InterruptedException | UnresolvedAddressException e) {
            e.printStackTrace();
        }

    }

    public void getToolsApi(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://simple-tool-rental-api.glitch.me/tools"))
                .header("Content-Type", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        System.out.println(request.headers() + " " + request.bodyPublisher());
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            try {
                File myObj = new File("C:\\Users\\onojaaa\\Documents\\Dev\\filename.txt");
                if (myObj.createNewFile()) {
                  System.out.println("File created: " + myObj.getName());
                } else {
                  System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            try {
                FileWriter myWriter = new FileWriter("C:\\Users\\onojaaa\\Documents\\Dev\\filename.txt", true);
                myWriter.write(dtf.format(now) + " \nGet tools Request::: ");
                myWriter.write(" " + request.bodyPublisher() + "\n");
                myWriter.write(dtf.format(now) + " \nGet Tools Response ::: ");
                myWriter.write(response.body() + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        } catch (IOException | InterruptedException | UnresolvedAddressException e) {
            e.printStackTrace();
        }
    }

    public static void placeOrderApi(String ID, String Comment){

        String jsonBody = "{\"ID\":\"" + ID + "\", \"Comment\":\"" + Comment + "\"}"; // Example JSON body

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com/api")) // Replace with your API URL
                .header("Content-Type", "application/json")
                .header("X-RapidAPI-Host", "example-host")
                .header("X-RapidAPI-Key", "your-rapidapi-key")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            try {
                File myObj = new File("C:\\Users\\onojaaa\\Documents\\Dev\\filename.txt");
                if (myObj.createNewFile()) {
                  System.out.println("File created: " + myObj.getName());
                } else {
                  System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            try {
                FileWriter myWriter = new FileWriter("C:\\Users\\onojaaa\\Documents\\Dev\\filename.txt");
                myWriter.write("Get Place Order Request:::");
                myWriter.write(" " + request.bodyPublisher() + "\n");
                myWriter.write("Get Place Order Response " + dtf.format(now));
                myWriter.write(response.statusCode());
                myWriter.write(response.body());
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        } catch (IOException | InterruptedException | UnresolvedAddressException e) {
            e.printStackTrace();
        }
    }

    public  void registerApi(String clientName, String clientEmail){

        String jsonBody = "{\"clientName\":\""+ clientName +"\", \"clientEmail\":\""+ clientEmail +"\"}"; // JSON body

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://simple-tool-rental-api.glitch.me/api-clients")) // API URL
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            jsonResponse = response.body();
//            JSONObject jsonObject = jsonParser.parseString(jsonBody).getAsJsonObject();
        } catch (IOException | InterruptedException | UnresolvedAddressException e) {
            e.printStackTrace();
        }
    }

    public void printJson(){

        
    }
}
