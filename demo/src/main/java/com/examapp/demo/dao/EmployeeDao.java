package com.examapp.demo.dao;

import com.examapp.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository

public interface EmployeeDao  extends JpaRepository <Employee , Integer> {

    Employee findByNom(String nom);

    Optional<Employee> findByCin(String cin);


}