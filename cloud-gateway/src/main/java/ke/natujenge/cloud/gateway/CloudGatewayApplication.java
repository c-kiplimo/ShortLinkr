package ke.natujenge.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
public class CloudGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(CloudGatewayApplication.class, args);

//		new SpringApplicationBuilder(CloudGatewayApplication.class)
//				.web(WebApplicationType.REACTIVE)
//				.run(args);

	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "POST", "PUT", "DELETE");

				registry.addMapping("/shortener/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "POST");
			}
		};
	}


}
