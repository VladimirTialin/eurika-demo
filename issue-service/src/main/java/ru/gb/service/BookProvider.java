package ru.gb.service;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.*;
import ru.gb.Book;

import java.util.UUID;

@Service
public class BookProvider {
    private final WebClient webClient;

    public BookProvider(ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
    }

    public UUID getRandomBook() {
        Book randomBook = webClient.get()
                .uri("http://book-service/api/book/random")
                .retrieve()
                .bodyToMono(Book.class)
                .block();

        return randomBook.getId();
    }
}
