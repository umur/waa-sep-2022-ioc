package miu.edu.springdata.Controller;

import miu.edu.springdata.Entity.Category;
import miu.edu.springdata.Service.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;
    @PostMapping("/categories")
    public void save(@RequestBody Category category){
        categoryService.save(category);
    }
}
