# URLConnection in Java

`URLConnection` is a Java class that facilitates connecting to a remote server using its URL. It establishes a communication link between a Java application and a resource on the internet represented by a URL. In this README, we'll explore the key concepts of `URLConnection` and how to use it.

## Key Concepts

### 1. Creating a URL Instance

Before establishing a connection, you need to create an instance of the `URL` class using the `new` operator. This `URL` instance represents the resource you want to interact with over the internet. For example:

```java
URL url = new URL("http://www.google.com");
```

### 2. Opening a Connection

Next, you use the `openConnection` method of the `URL` instance to create a new instance of the `URLConnection` object. This connection object serves as the bridge between your application and the remote resource:

```java
URLConnection urlConnection = url.openConnection();
```

### 3. Reading Data

Once the connection is established, you can use methods like `getInputStream()` to read data from the remote resource. In the following example, we use a `BufferedReader` to read and display data from the URL:

```java
BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
String line;
int count = 0;
while ((line = reader.readLine()) != null) {
    System.out.println(line);
    if (count > 5) {
        System.out.print("and so on......");
        break;
    }
    count++;
}
reader.close();
```

This code reads the content from the URL line by line and prints it to the console. It also demonstrates how to limit the output by printing "and so on......" after reading a certain number of lines (in this case, 5 lines).

## Example Code

Here's an example Java program that uses `URLConnection` to connect to a remote URL and display its content:

```java
public class UrlConnectionDemo {

    public static void main(String[] args) {
        execute_demo_for_urlConnection_class();
    }

    public static void execute_demo_for_urlConnection_class() {
        try {
            URL url = new URL("https://www.youtube.com/watch?v=VI4s1w5ywzc");
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (count > 5) {
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
```

This example connects to a YouTube video URL, retrieves the content, and prints it to the console.

Understanding `URLConnection` in Java allows you to interact with remote resources over the internet, making it a valuable tool for web scraping, data retrieval, and more.