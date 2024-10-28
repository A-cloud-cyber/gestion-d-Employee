package com.examapp.demo.controllers;

import com.examapp.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("employees")
import java.util.List;

public class EmployeeController {
    private EmployeeService clientService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeResponseDto>> getEmployees() {
        return new EmployeeEntity<>(EmployeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<EmployeeResponseDto> save(@Valid @RequestBody() EmployeeRequestDto clientRequestDto) {
        EmployeeResponseDto employeeResponseDto = employeeService.save(employeeRequestDto);
        return new ResponseEntity<>(clientResponseDto, HttpStatus.CREATED);
    }


    @GetMapping("/nom/{nom}")
    public ResponseEntity<EmployeeResponseDto> findByNom(@PathVariable() String nom) {
        employeeResponseDto employeeResponseDto = employeeService.findByNom(nom);
        return ResponseEntity.ok(clientResponseDto);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<EmployeeResponseDto> update(@Valid @RequestBody() EmployeeRequestDto employeeRequestDto, @PathVariable() Integer id) throws NotFoundException {
        EmployeeResponseDto clientResponseDto = clientService.update(employeeRequestDto, id);
        return ResponseEntity.accepted().body(employeeResponseDto);
    }
}

}
