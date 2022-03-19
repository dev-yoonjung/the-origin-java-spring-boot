package springboot.mission.basic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springboot.mission.basic.controller.dto.CategoryDTO;
import springboot.mission.basic.entity.CategoryEntity;
import springboot.mission.basic.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
    private final CategoryRepository categoryRepository;

    public CategoryService(@Autowired CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO createCategory(CategoryDTO dto){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(dto.getName());
        categoryEntity = this.categoryRepository.save(categoryEntity);
        return new CategoryDTO(categoryEntity);
    }

    public CategoryDTO readCategory(Long id) {
        Optional<CategoryEntity> categoryEntityOptional = this.categoryRepository.findById(id);
        if (categoryEntityOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return new CategoryDTO(categoryEntityOptional.get());
    }

    public List<CategoryDTO> readCategoryAll(){
        List<CategoryDTO> categoryDtoList = new ArrayList<>();
        this.categoryRepository.findAll().forEach(categoryEntity ->
                categoryDtoList.add(new CategoryDTO(categoryEntity)));
        return categoryDtoList;
    }
}
