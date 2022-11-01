package miu.edu.springdata.Controller;

import miu.edu.springdata.Entity.User;
import miu.edu.springdata.Service.Impl.UserServiceImpl;
import miu.edu.springdata.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public List<User> findUsers() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user){
         userService.save(user);
    }

    @GetMapping("/credi")
    public List<UserDto> getUserCredentials(){
        return userService.findAllDto();
    }
}
