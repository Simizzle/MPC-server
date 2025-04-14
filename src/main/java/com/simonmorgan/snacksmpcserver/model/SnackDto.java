package com.simonmorgan.snacksmpcserver.model;

public record SnackDto(String snack_name, String snack_description, int price_in_pence, int category_id) {
}
