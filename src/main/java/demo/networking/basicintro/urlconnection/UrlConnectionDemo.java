package demo.networking.basicintro.urlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDemo {

    public static void main(String[] args) {
        execute_demo_for_urlConnection_class();
    }

    public static void execute_demo_for_urlConnection_class(){
        try {
            URL url = new URL("https://www.youtube.com/watch?v=VI4s1w5ywzc");
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            int count = 0;
            while((line = reader.readLine())!=null){
                System.out.println(line);
                if(count > 5){
                    System.out.print("and so on......");
                    break;
                }
                count++;
            }
            reader.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
