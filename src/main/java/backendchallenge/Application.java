package backendchallenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application .class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ItemRepository repository) {
        return (args) -> {
            // populate the repository for the challenge
            repository.save(new Item("Comment faire pousser des radis ?", "1.Semer 2.Arroser 3.Attendre", "Potager Radis"));
            repository.save(new Item("Comment faire pousser des carottes ?", "1.Semer 2.Arroser 3.Attendre", "Potager Carotte"));
            repository.save(new Item("Comment faire de la course à pied ?", "1.Mettre ses chaussures 2.Courrir", "Sport Running"));
            repository.save(new Item("Comment faire du vélo ?", "1.Monter sur son vélo 2.Pédaler", "Sport Vélo"));
            repository.save(new Item("Comment faire du cuire du riz ?", "1.Mettre le riz et l'eau dans l'autocuiseur 2.Appuyer sur le bouton ON 3.Attendre", "Cuisine Riz"));
            repository.save(new Item("Comment faire du pain ?", "1.Mettre la farine, la levure et l'eau dans la machine à pain 2.Appuyer sur le bouton ON 3.Attendre", "Cuisine Pain"));
        };
    }
}
