package com.simonmorgan.snacksmpcserver.dao;

import com.simonmorgan.snacksmpcserver.model.SnackDto;
import com.simonmorgan.snacksmpcserver.model.SnackItems;
import com.simonmorgan.snacksmpcserver.model.Snacks;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Component
public class SnacksDAO {
    private static final String BASE_URL = "https://snacks-api-nzwy.onrender.com/api/";
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
        System.out.println(snacks);
        return snacks;
    }

    public static SnackItems postSnack(SnackDto snackDto) {
        SnackItems snack = null;
        snack = WEB_CLIENT
                .post()
                .uri("snacks")
                .body(Mono.just(snackDto), SnackDto.class)
                .retrieve()
                .bodyToMono(SnackItems.class)
                .block();

        return snack;
    }

    public static SnackItems putSnack(Long snackId, SnackDto snackDto) {
        SnackItems snack = null;
        snack = WEB_CLIENT
                .put()
                .uri(BASE_URL + "snacks/" + snackId)
                .body(Mono.just(snackDto), SnackDto.class)
                .retrieve()
                .bodyToMono(SnackItems.class)
                .block();

        return snack;
    }

    public static String deleteSnack(Long snackId) {
        return WEB_CLIENT
                .delete()
                .uri(BASE_URL + "snacks/" + snackId)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}