package com.pos_application.pos.util.mappers;


import com.pos_application.pos.dto.response.ItemGetResponseDTO;
import com.pos_application.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel= "Spring")

public interface ItemMappers {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);

    List<ItemGetResponseDTO> listDTOToPage (Page<Item> items);
}
