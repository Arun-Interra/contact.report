package mazda.field.portal.contact.report;

import mazda.field.portal.contact.report.entity.User;
import mazda.field.portal.contact.report.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class MazdaFieldPortalApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUsers(){
		List<User> users = Stream.of(
				new User(101,"user1","pwd1"),
				new User(102,"user2","pwd2"),
				new User(103,"user3","pwd3")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}
	public static void main(String[] args) {
		SpringApplication.run(MazdaFieldPortalApplication.class, args);
	}

}
