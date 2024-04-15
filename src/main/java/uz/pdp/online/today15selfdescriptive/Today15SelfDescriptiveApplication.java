package uz.pdp.online.today15selfdescriptive;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import uz.pdp.online.today15selfdescriptive.entity.Comment;
import uz.pdp.online.today15selfdescriptive.repo.CommentRepository;

import java.util.List;

import static org.hibernate.query.results.Builders.fetch;

@SpringBootApplication
@RequiredArgsConstructor
public class Today15SelfDescriptiveApplication implements CommandLineRunner {

    private final CommentRepository commentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Today15SelfDescriptiveApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        RestTemplate restTemplate = new RestTemplate();
        Comment[] comments = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Comment[].class);

        commentRepository.saveAll(List.of(comments));

        for (Comment comment : comments) {

            System.out.println(comment);
            System.out.println();



        }

    }
}
