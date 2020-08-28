package com.winter.springdatademo.repository;

import com.winter.springdatademo.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName : EmployeeCrudRespository  //类名
 * @Description : 继承CRUD Respository  //描述
 * @Author : Winter  //作者
 * @Date: 2020-08-24 15:52  //时间
 */
public interface EmployeeCrudRespository extends CrudRepository<Employee,Integer> {


//    public List<Employee> saveAll(List<Employee> employees);
}
