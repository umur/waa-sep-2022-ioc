package miu.edu.springdata.Service.Impl;

import miu.edu.springdata.Entity.Address;
import miu.edu.springdata.Repository.AddressRepository;
import miu.edu.springdata.Service.AddressService;
import miu.edu.springdata.dto.AddressDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ModelMapper modelMapper;
    public List<Address> findAll(){
        List<Address> addresses = (List<Address>) addressRepository.findAll();
        return addresses;
    };

    @Transactional
    public void save(Address address){
        addressRepository.save(address);
    }

    public List<AddressDto> getZipCity(){
        List<Address> addresses = (List<Address>) addressRepository.findAll();
        return addresses.stream().map(Address -> modelMapper.map(Address, AddressDto.class)).collect(Collectors.toList());
    }


}
