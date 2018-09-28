package be.issep.riskmanagement.api;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.issep.riskmanagement.api.entities.Choice;
import be.issep.riskmanagement.api.entities.Location;
import be.issep.riskmanagement.api.entities.WorkContext;
import be.issep.riskmanagement.api.repositories.ChoiceRepository;
import be.issep.riskmanagement.api.repositories.LocationRepository;
import be.issep.riskmanagement.api.repositories.WorkContextRepository;

@SpringBootApplication
public class RiskmanagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskmanagementApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(
			LocationRepository locRepo,
			WorkContextRepository wcRepo,
			ChoiceRepository choiceRepo
			) {
		return args -> {
			locRepo.save(new Location("ZVVB", "test location", "A location for testing"));
			Choice[] choices = new Choice[] {
					new Choice("dangerous", "wc"),
					new Choice("hazardous", "wc")
			};
			for (Choice ch: choices) {
				choiceRepo.save(ch);
			}
			WorkContext ctx = new WorkContext("Site A", "A", "a nice site", "a nice site indeed");
			ctx.setTypes(Arrays.asList(choices));
			wcRepo.save(ctx);
		};
	}
}
