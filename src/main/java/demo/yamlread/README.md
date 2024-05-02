Reading a YAML file in Java typically involves using a third-party library, 
as the Java standard library does not include native support for YAML parsing. 
One of the most popular libraries for this purpose is SnakeYAML. 
Here’s how you can use it to read a YAML file:
1. Add SnakeYAML to Your Project
   <dependency>
        <groupId>org.yaml</groupId>
        <artifactId>snakeyaml</artifactId>
        <version>1.29</version> <!-- Check for the latest version on Maven Central -->
   </dependency>
2. Define a Java class that corresponds to the structure of your YAML data.
3. Read the yaml file and deserialize it using the load present in the object created from the yaml(snakeyaml) library.
