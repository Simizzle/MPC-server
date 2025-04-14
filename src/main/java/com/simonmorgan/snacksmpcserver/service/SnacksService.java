package com.simonmorgan.snacksmpcserver.service;

import com.simonmorgan.snacksmpcserver.dao.SnacksDAO;
import com.simonmorgan.snacksmpcserver.model.SnackDto;
import com.simonmorgan.snacksmpcserver.model.Snacks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SnacksService {

    private static final Logger log = LoggerFactory.getLogger(SnacksService.class);

    @Tool(name = "get_all_snacks", description = "Get a list of snacks from the nc_snacks api")
    public Snacks getSnacks() {
        return SnacksDAO.getSnacks("snacks");
    }


    @Tool(name = "add_snack_to_database", description = "Post a snack to the nc_snack api")
    public void addSnack(String snack_name, String snack_description, int price_in_pence, int category_id) {
        SnacksDAO.postSnack(new SnackDto(snack_name, snack_description, price_in_pence, category_id));
    }
}
