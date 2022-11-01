package miu.edu.springdata.Service.Impl;

import miu.edu.springdata.Entity.Product;
import miu.edu.springdata.Entity.User;
import miu.edu.springdata.Repository.ProductRepository;
import miu.edu.springdata.Repository.UserRepository;
import miu.edu.springdata.Service.UserService;
import miu.edu.springdata.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<User> findAll() {
        List<User> users = (List<User>) userRepository.findAll();
        System.out.println(users);
        return users;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public List<UserDto> findAllDto(){
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream().map(x->modelMapper.map(x,UserDto.class)).collect(Collectors.toList());
    }


}


