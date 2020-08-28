package com.winter.springdatademo.repository;

import com.winter.springdatademo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePageAndSortResposiory extends PagingAndSortingRepository<Employee,Integer> {


    public Page<Employee> findAllByAge(Pageable pageAble,int age);

}
