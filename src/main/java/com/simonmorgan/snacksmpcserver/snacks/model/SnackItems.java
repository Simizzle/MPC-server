package com.simonmorgan.snacksmpcserver.snacks.model;

public record SnackItems(long snack_id, String snack_name, String snack_description, int price_in_pence, int category_id) {
}
