package com.pos_application.pos.controller;


import com.pos_application.pos.dto.paginated.PaginatedResponseItemDTO;
import com.pos_application.pos.dto.request.ItemSaveRequestDTO;
import com.pos_application.pos.dto.response.ItemGetResponseDTO;
import com.pos_application.pos.service.ItemService;
import com.pos_application.pos.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(
            path = {"/save"}
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String Message = itemService.saveItem(itemSaveRequestDTO);
//        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
//                new StandardResponse(201,"Saved Successfully",Message), HttpStatus.CREATED
//        );
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Saved Successfully",Message), HttpStatus.CREATED
        );

    }

    @GetMapping(path = "/get_by_name",
            params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemDTOS;
    }

    @GetMapping(path = "/get_by_name_with_mapstruct",
            params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTOS;
        itemDTOS = itemService.getItemByNameAndStatusByMapstruct(itemName);
        return itemDTOS;
    }

    @GetMapping(path = "/get_all_items_by_status",
            params = {"activeStatus", "page", "size"}
    )
    public ResponseEntity<StandardResponse> getItemsByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size")  @Max(50) int size) {
       // List<ItemGetResponseDTO> itemDTOS = itemService.getItemsByActiveStatus(activeStatus);
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemsByActiveStatusWithPaginated(activeStatus,page,size);
        return new ResponseEntity<StandardResponse>(new StandardResponse(
                200,"Success",paginatedResponseItemDTO), HttpStatus.OK

        );
    }
}
