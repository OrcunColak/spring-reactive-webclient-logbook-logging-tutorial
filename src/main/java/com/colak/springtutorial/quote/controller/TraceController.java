package com.colak.springtutorial.quote.controller;

import com.colak.springtutorial.quote.domain.ApiResponse;
import com.colak.springtutorial.quote.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;

@RestController
@RequestMapping("/v1/trace")

@RequiredArgsConstructor
@Slf4j
public class TraceController {

    public static final String JSON_PLACEHOLDER_BASE_URL = "https://jsonplaceholder.typicode.com";

    private final WebClient webClient;


    // http://localhost:8080/v1/trace/log
    @GetMapping(value = "/log", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ApiResponse> getLogging() {
        //Call webclient
        var postResponse = createPost();

        return postResponse.flatMap(post -> Mono.just(new ApiResponse(post, "response")));
    }

    private Mono<Post> createPost() {
        var post = new Post("foo", "bar", 1);

        return webClient.post()
                .uri(MessageFormat.format("{0}/posts", JSON_PLACEHOLDER_BASE_URL))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(post), Post.class)
                .retrieve()
                .bodyToMono(Post.class);
    }
}
