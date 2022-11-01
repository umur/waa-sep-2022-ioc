package miu.edu.springdata.Service.Impl;

import miu.edu.springdata.Entity.Category;
import miu.edu.springdata.Repository.CategoryRepository;
import miu.edu.springdata.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public void save(Category category){
        categoryRepository.save(category);
    }
}
