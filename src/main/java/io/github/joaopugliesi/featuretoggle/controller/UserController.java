package io.github.joaopugliesi.featuretoggle.controller;

import io.github.joaopugliesi.featuretoggle.dto.UserDto;
import io.github.joaopugliesi.featuretoggle.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<Page<UserDto>> ListAll(@PageableDefault(page = 0,
                                                size = 10,
                                                 sort = "id") Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDto>> findByIs(@PathVariable Long id) {
        Optional<UserDto> dto = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto dto) {
        dto = service.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
