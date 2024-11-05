package ma.xproce.videoservice;

import ma.xproce.videoservice.dao.entities.Creator;
import ma.xproce.videoservice.dao.entities.Video;
import ma.xproce.videoservice.dao.repositories.CreatorRepository;
import ma.xproce.videoservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VideoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoServerApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            // Créer et sauvegarder des créateurs
            Creator creator1 = new Creator();
            creator1.setName("x");
            creator1.setEmail("x@gmail.com");

            Creator creator2 = new Creator();
            creator2.setName("y");
            creator2.setEmail("y@gmail.com");

            Creator creator3 = new Creator();
            creator3.setName("z");
            creator3.setEmail("z@gmail.com");

            creatorRepository.saveAll(List.of(creator1, creator2, creator3));

            // Créer et sauvegarder des vidéos
            Video video1 = new Video();
            video1.setName("vEducation");
            video1.setUrl("vEducation.com");
            video1.setDescription("this is an educational video");
            video1.setCreator(creator2);  // Utilise creator2

            Video video2 = new Video();
            video2.setName("vGaming");
            video2.setUrl("vGaming.com");
            video2.setDescription("this is a Gaming video");
            video2.setCreator(creator1);  // Utilise creator1

            Video video3 = new Video();
            video3.setName("vEntertainment");
            video3.setUrl("vEntertainment.com");
            video3.setDescription("this is an entertainment video");
            video3.setCreator(creator3);  // Utilise creator3

            videoRepository.saveAll(List.of(video1, video2, video3));
        };
    }
}
