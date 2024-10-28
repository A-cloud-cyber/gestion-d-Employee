package com.examapp.demo.service;

import com.examapp.demo.dto.EmployeeRequestDto;
import com.examapp.demo.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
   EmployeeResponseDto save(EmployeeRequestDto);

    EmployeeResponseDto findById(Integer id);


    EmployeeResponseDto findByNom(String nom);

    void delete(Integer id);

    EmployeeResponseDto update(EmployeeRequestDto clientRequestDto, Integer id) throws NotFoundException;

    List<EmployeeResponseDto> findAll();
}
