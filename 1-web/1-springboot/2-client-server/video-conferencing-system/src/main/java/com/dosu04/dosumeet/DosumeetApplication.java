package com.dosu04.dosumeet;

import com.dosu04.dosumeet.services.UserService;
import com.dosu04.dosumeet.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DosumeetApplication {

	public static void main(String[] args) {
		SpringApplication.run(DosumeetApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserService service
	) {
		return args -> {
			service.register(User.builder()
					.username("Dosu")
					.email("dosu@mail.com")
					.password("2004")
					.build());

			service.register(User.builder()
					.username("Dora")
					.email("dora@mail.com")
					.password("2005")
					.build());

			service.register(User.builder()
					.username("Dennis")
					.email("dennis@mail.com")
					.password("2002")
					.build());
		};
	}


}
