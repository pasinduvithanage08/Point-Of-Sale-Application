package com.pos_application.pos.service;

import com.pos_application.pos.dto.paginated.PaginatedResponseItemDTO;
import com.pos_application.pos.dto.request.ItemSaveRequestDTO;
import com.pos_application.pos.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName);

    List<ItemGetResponseDTO> getItemsByActiveStatus(boolean activeStatus);

    PaginatedResponseItemDTO getItemsByActiveStatusWithPaginated(boolean activeStatus, int page, int size);
}
