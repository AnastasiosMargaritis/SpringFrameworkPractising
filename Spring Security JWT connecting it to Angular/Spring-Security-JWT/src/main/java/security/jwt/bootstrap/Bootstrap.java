package security.jwt.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import security.jwt.domain.User;
import security.jwt.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = Stream.of(
                new User(1L, "AnasMarg", "1234", "anastasismargaritis@gmail.com"),
                new User(2L, "AnthiMl", "1234", "anthi.molozi@gmail.com"),
                new User(3L, "ElMarg", "1234", "elmargar@gmail.com")
        ).collect(Collectors.toList());

        this.userRepository.saveAll(users);
    }
}
