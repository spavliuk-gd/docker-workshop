package com.dockerworkshop.feedservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@EnableEurekaClient
@EnableJpaRepositories
@EnableFeignClients
@SpringBootApplication
public class FeedserviceApplication {

	@RestController
	@RequestMapping(path = "/post")
	public static class Controller {
		private final PostRepository repository;

		private final UserClient userClient;

		public Controller(PostRepository repository, UserClient userClient) {
			this.repository = repository;
			this.userClient = userClient;
		}

		@PostMapping
		public Post create(@RequestBody Post post) {

		    userClient.find(post.getUserId());

			return repository.save(post);
		}

		@GetMapping
		public Iterable<Post> listAll() {
			return repository.findAll();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(FeedserviceApplication.class, args);
	}

}
