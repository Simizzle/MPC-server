package com.simonmorgan.snacksmpcserver.dao;

import com.simonmorgan.snacksmpcserver.model.SnackItems;
import com.simonmorgan.snacksmpcserver.model.Snacks;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.ArrayList;
import java.util.List;

@Component
public class SnacksDAO {

    private static final String BASE_URL = "https://nc-snacks-snwj.onrender.com/api/";

    public static Snacks getSnacks(String endpoint) {

        WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();

        Snacks snacks = null;

        try {
            snacks = webClient
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
}