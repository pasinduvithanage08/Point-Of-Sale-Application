package com.pos_application.pos.util.mappers;

import com.pos_application.pos.dto.response.ItemGetResponseDTO;
import com.pos_application.pos.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T05:16:01+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Oracle Corporation)"
)
@Component
public class ItemMappersImpl implements ItemMappers {

    @Override
    public List<ItemGetResponseDTO> entityListToDtoList(List<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>( items.size() );
        for ( Item item : items ) {
            list.add( itemToItemGetResponseDTO( item ) );
        }

        return list;
    }

    @Override
    public List<ItemGetResponseDTO> listDTOToPage(Page<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>();
        for ( Item item : items ) {
            list.add( itemToItemGetResponseDTO( item ) );
        }

        return list;
    }

    protected ItemGetResponseDTO itemToItemGetResponseDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemGetResponseDTO itemGetResponseDTO = new ItemGetResponseDTO();

        itemGetResponseDTO.setItemName( item.getItemName() );
        itemGetResponseDTO.setBalanceQty( item.getBalanceQty() );
        itemGetResponseDTO.setSupplierPrice( item.getSupplierPrice() );
        itemGetResponseDTO.setSellingPrice( item.getSellingPrice() );

        return itemGetResponseDTO;
    }
}
