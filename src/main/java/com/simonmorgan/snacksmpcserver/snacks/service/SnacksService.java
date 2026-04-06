package com.simonmorgan.snacksmpcserver.snacks.service;

import com.simonmorgan.snacksmpcserver.snacks.dao.SnacksDAO;
import com.simonmorgan.snacksmpcserver.snacks.model.SnackDto;
import com.simonmorgan.snacksmpcserver.snacks.model.SnackItems;
import com.simonmorgan.snacksmpcserver.snacks.model.Snacks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.stereotype.Service;

@Service
public class SnacksService {

    private static final Logger log = LoggerFactory.getLogger(SnacksService.class);

    @McpTool(name = "get_all_snacks", description = "Get a list of snacks from the snacks api")
    public Snacks getSnacks() {
        Snacks snacks = SnacksDAO.getSnacks("snacks");
        log.info(String.valueOf(snacks));
        return snacks;
    }


    @McpTool(name = "add_snack_to_database", description = "Post a snack to the snack api")
    public void addSnack(SnackDto snack) {
        SnackItems newSnack = SnacksDAO.postSnack(snack);
        log.info(String.valueOf(newSnack));
    }

    @McpTool(name = "update_snack_in_database_by_id", description = "Update a snack in the snack api by id using a PUT request")
    public void putSnack(Long snackId, SnackDto snack) {
        SnackItems updatedSnack = SnacksDAO.putSnack(snackId, snack);
        log.info(String.valueOf(updatedSnack));
    }

    @McpTool(name = "delete_snack_in_database_by_id", description = "Update a snack in the snack api by id using a DELETE request")
    public void deleteSnack(Long snackId) {
        SnacksDAO.deleteSnack(snackId);
    }
}
