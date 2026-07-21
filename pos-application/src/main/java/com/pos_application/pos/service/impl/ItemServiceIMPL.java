package com.pos_application.pos.service.impl;

import com.pos_application.pos.dto.paginated.PaginatedResponseItemDTO;
import com.pos_application.pos.dto.request.ItemSaveRequestDTO;
import com.pos_application.pos.dto.response.ItemGetResponseDTO;
import com.pos_application.pos.entity.Item;
import com.pos_application.pos.exception.NotFoundException;
import com.pos_application.pos.repo.itemRepo;
import com.pos_application.pos.service.ItemService;
import com.pos_application.pos.util.mappers.ItemMappers;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.springframework.data.domain.PageRequest.*;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private itemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMappers itemMappers;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return item.getItemId() + " " + " Saved Successfully";
        } else {
            throw new DuplicateKeyException("Already added");
        }


    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {

        Boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActive(itemName, b);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>() {
            }.getType());
            return itemGetResponseDTOS;
        } else {
            throw new NotFoundException("Item is Not Active");
        }

    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName) {
        Boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActive(itemName, b);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMappers.entityListToDtoList(items);
            return itemGetResponseDTOS;
        } else {
            throw new NotFoundException("Item is Not Active");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemsByActiveStatus(boolean activeStatus) {
        List<Item> items = itemRepo.findAllByActiveEquals(activeStatus);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMappers.entityListToDtoList(items);
            return itemGetResponseDTOS;
        } else {
            throw new NotFoundException("Item is Not Active");
        }
    }

    @Override
    public PaginatedResponseItemDTO getItemsByActiveStatusWithPaginated(boolean activeStatus, int page, int size) {
        Page<Item> items = (Page<Item>) itemRepo.findAllByActiveEquals(activeStatus,PageRequest.of(page,size));
        int count = itemRepo.countAllByActive(activeStatus);
        if (items.getSize()<1){
            throw new NotFoundException("No Data Found");
        }
        PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                itemMappers.listDTOToPage(items),count
        );
        return paginatedResponseItemDTO;
    }
}






