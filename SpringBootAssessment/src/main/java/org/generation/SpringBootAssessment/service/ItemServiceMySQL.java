package org.generation.SpringBootAssessment.service;

import org.generation.SpringBootAssessment.repository.*;
import org.generation.SpringBootAssessment.repository.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;

@Service
public class ItemServiceMySQL implements ItemService{

    private final ItemRepository itemRepository;

    public ItemServiceMySQL(@Autowired ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    //save method is in Service layer, and will be called by the controller
    @Override
    public Item save(Item item) {
//save an item to database
        //perform the action CRUD - Create(new item), update(existing item)
        return this.itemRepository.save(item);

    }

    @Override
    public void delete(int id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public List<Item> all() {
        List<Item> result = new ArrayList<>();
        this.itemRepository.findAll().forEach(result::add);
        return result; // in a from of arraylist
    }

    @Override
    public Item findById(int id) {
        Optional<Item> item = this.itemRepository.findById(id);
        Item itemResponse = item.get();
        return itemResponse;
    }
}