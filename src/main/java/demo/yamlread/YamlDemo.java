package demo.yamlread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class YamlDemo {

    public static void main(String[] args){
        System.out.println("Demo for reading yaml file");
        execute_demo_for_reading_content_from_the_yaml_file();
    }


    public static void execute_demo_for_reading_content_from_the_yaml_file(){
        Yaml yaml = new Yaml(new Constructor(Person.class));
        try{
            InputStream inputStream = new FileInputStream("./resourcefiles/person-details.yaml");
            Person person = yaml.load(inputStream);
            System.out.println(person);
        }catch(FileNotFoundException ex){
            System.out.println(ex.getStackTrace());
        }
    }

}
