package dz.hashtag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class HashtagApplication {

    public static void main(String[] args) {
        SpringApplication.run(HashtagApplication.class, args);
    }
    
}
