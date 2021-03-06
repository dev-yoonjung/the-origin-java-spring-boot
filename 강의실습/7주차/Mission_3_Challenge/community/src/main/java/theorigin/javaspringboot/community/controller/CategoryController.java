package theorigin.javaspringboot.community.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theorigin.javaspringboot.community.controller.dto.CategoryDTO;
import theorigin.javaspringboot.community.service.CategoryService;

import java.util.Collection;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;

    public CategoryController(@Autowired CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDto){
        return ResponseEntity.ok(this.categoryService.createCategory(categoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> readCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.categoryService.readCategory(id));
    }

    @GetMapping
    public ResponseEntity<Collection<CategoryDTO>> readCategoryAll(){
        return ResponseEntity.ok(this.categoryService.readCategoryAll());
    }
}
