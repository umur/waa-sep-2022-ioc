package miu.edu.springdata.Controller;

import miu.edu.springdata.Entity.Address;
import miu.edu.springdata.Service.AddressService;
import miu.edu.springdata.Service.Impl.AddressServiceImpl;
import miu.edu.springdata.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressServiceImpl addressService;
    @GetMapping("/address")
    List<Address> findAllAddress(){
        return addressService.findAll();
    }

    @PostMapping("/address")
    void save(@RequestBody Address address){
         addressService.save(address);
    }

    @GetMapping("/city&Zip")
    List<AddressDto> findCityAndZipCode(){
        return addressService.getZipCity();
    }
}
