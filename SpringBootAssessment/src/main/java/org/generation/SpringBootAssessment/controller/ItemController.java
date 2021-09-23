package org.generation.SpringBootAssessment.controller;


import org.generation.SpringBootAssessment.component.FileUploadUtil;
import org.generation.SpringBootAssessment.controller.dto.*;
import org.generation.SpringBootAssessment.repository.entity.*;
import org.generation.SpringBootAssessment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/item")

public class ItemController {

    final ItemService itemService;
//Autowired will implicit inject the ItemServices as a dependency to ItemController
    //so that we can call the methods in the ItemService

    @Value("${image.folder}")
    private String imageFolder;

    public ItemController(@Autowired ItemService itemService)
    {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getItems()
    {
        return itemService.all();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Item findItemById(@PathVariable Integer id)
    {
        return itemService.findById(id);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {
        itemService.delete(id);
    }

    @CrossOrigin
    @PostMapping("/add")
    public Item save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="date", required = true) Date date) throws IOException {

            /*  String uploadDir1 = "productImages/images";
       String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);*/

        ItemDTO itemDTO = new ItemDTO(title, description, date);
        return itemService.save(new Item(itemDTO));
    }

}
