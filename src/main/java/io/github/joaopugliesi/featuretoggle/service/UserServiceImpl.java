package io.github.joaopugliesi.featuretoggle.service;

import io.github.joaopugliesi.featuretoggle.dto.UserDto;
import io.github.joaopugliesi.featuretoggle.entity.User;
import io.github.joaopugliesi.featuretoggle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    public UserDto save(UserDto dto) {
        User entity = new User();
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setDateCreated(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }


    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> list = repository.findAll(pageable);
        return list.map(x -> new UserDto(x));
    }

    public Optional<UserDto> findById(Long id) {
        Optional<User> userOptional = repository.findById(id);
        User entity = userOptional.get();
        return Optional.of(new UserDto(entity));
    }


    public UserDto update(Long id, UserDto dto) {
        Optional<User> userOptional = repository.findById(id);
        User entity = new User();
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        repository.save(entity);
        return new UserDto(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
