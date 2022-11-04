package ua.lviv.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import ua.lviv.iot.view.View;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private View view;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        view.show();
    }
}
