package com.simonmorgan.snacksmpcserver.dao;

import com.simonmorgan.snacksmpcserver.model.SnackDto;
import com.simonmorgan.snacksmpcserver.model.SnackItems;
import com.simonmorgan.snacksmpcserver.model.Snacks;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Component
public class SnacksDAO {

    private static final String BASE_URL = "https://nc-snacks-snwj.onrender.com/api/";
    private static final WebClient WEB_CLIENT = WebClient.builder().baseUrl(BASE_URL).build();

    public static Snacks getSnacks(String endpoint) {
        Snacks snacks = null;

        try {
            snacks = WEB_CLIENT
                    .get()
                    .uri(endpoint)
                    .retrieve()
                    .bodyToMono(Snacks.class)
                    .block();
        } catch (WebClientResponseException e) {
            System.out.println(e.getMessage());
        }
        return snacks;
    }

    public static Mono<SnackItems> postSnack(SnackDto snackDto) {
        SnackItems snack = null;
        return WEB_CLIENT
                .post()
                .uri("/snacks")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(snackDto)
                .retrieve()
                .bodyToMono(SnackItems.class);

    }
}