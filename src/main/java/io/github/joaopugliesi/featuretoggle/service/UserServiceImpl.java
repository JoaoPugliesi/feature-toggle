package io.github.joaopugliesi.featuretoggle.service;

import io.github.joaopugliesi.featuretoggle.dto.UserDto;
import io.github.joaopugliesi.featuretoggle.entity.User;
import io.github.joaopugliesi.featuretoggle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDto save(UserDto dto) {
        User entity;
        entity = User.fromDto(dto);
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setDateCreated(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> list = repository.findAll(pageable);
        return list.map(x -> new UserDto(x));
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        Optional<User> userOptional = repository.findById(id);
        User entity = userOptional.get();
        return Optional.of(new UserDto(entity));
    }

    public UserDto update(Long id, UserDto dto) {
        User entity = repository.findById(id).orElseThrow();
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }

        if (dto.getPassword() != null) {
            entity.setPassword(dto.getPassword());
        }
        entity.setDateUpdate(LocalDateTime.now());
        repository.save(entity);
        return new UserDto(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
