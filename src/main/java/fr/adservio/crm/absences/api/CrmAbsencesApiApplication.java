package fr.adservio.crm.absences.api;

import fr.adservio.crm.absences.api.repositories.InitializeRepositoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class CrmAbsencesApiApplication implements CommandLineRunner {

    @Autowired
    InitializeRepositoriesService initializeRepositoriesService;

    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(CrmAbsencesApiApplication.class);
        sa.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        initializeRepositoriesService.initializeAbsencesTypes();
    }
}
