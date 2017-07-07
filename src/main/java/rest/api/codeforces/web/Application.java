
package rest.api.codeforces.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import rest.api.codeforces.model.DomainMarker;
import rest.api.codeforces.service.ServiceMarker;
import rest.api.codeforces.controller.ControllerMarker;

@Configuration
@ComponentScan(basePackageClasses = {DomainMarker.class, ServiceMarker.class, ControllerMarker.class})
@EnableWebMvc
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
