package org.ipc.synapsis.projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = {"org.ipc.synapsis.projet.repository"})
public class ProjetServerClass {

    public static void main(final String[] args) {

        SpringApplication.run(ProjetServerClass.class, args);
    }


}
