package org.generation.SpringBootAssessment.service;

import org.generation.SpringBootAssessment.repository.entity.*;

import java.util.List;

public interface ItemService {

    //Create methods/actions that you want to do with the item
    //Controller layer will call respective methods to perform the necessary task
    // that is requested by the client(browser)


    Item save(Item item);

    void delete(int id);

    List<Item> all();

    Item findById(int id);

}
