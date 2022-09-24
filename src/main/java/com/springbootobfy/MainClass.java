package com.springbootobfy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import java.io.FileNotFoundException;
import java.io.IOException;


@SpringBootApplication
@ServletComponentScan
public class MainClass {

    public static void main(String[] args) throws FileNotFoundException, IOException {       
        SpringApplication.run(MainClass.class, args);
    }
}
