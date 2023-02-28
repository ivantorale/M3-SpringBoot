
package clienteHTTP;
        
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ClienteHttp {


    public static void main(String[] args) {

        try{
            
            URL url = new URL("http://localhost:8080/Product" +  "/2");/*PRODUCT ID*/
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if(responseCode != 200){
                throw new RuntimeException("Error "+ responseCode);
            } else{
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext()){
                    informationString.append(scanner.nextLine());
                }
                scanner.close();

                System.out.println(informationString);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
   
