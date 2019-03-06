package em.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import em.backend.infrastructure.repository.member.MemberEntityRepository;

@SpringBootApplication
public class MemberApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}

	@Autowired
	MemberEntityRepository memberEntityRepository;
	
	@Override
	public void run(String... args) throws Exception {
	}

}
