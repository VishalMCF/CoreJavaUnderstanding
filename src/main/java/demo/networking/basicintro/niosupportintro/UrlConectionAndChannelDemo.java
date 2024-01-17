package demo.networking.basicintro.niosupportintro;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class UrlConectionAndChannelDemo {

    public static void main(String[] args) {
        execute_demo_for_channel_usage_with_url_connection();
    }

    private static void execute_demo_for_channel_usage_with_url_connection() {
        try{
            URL url = new URL("https://www.youtube.com/watch?v=VI4s1w5ywzc");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // by default buffer when uffer is created it will be a write buffer
            String line = null;
            int cnt = 0;
            while(readableByteChannel.read(buffer) > 0 ){
                line = new String(buffer.array());
                System.out.println(line);
                buffer.clear();
                if(cnt > 0) break;
                cnt ++;
            }
        }catch(Exception e){
            System.out.println("An exception occured while executing the demo...");
        }
    }

}
