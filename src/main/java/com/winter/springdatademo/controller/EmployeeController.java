package com.winter.springdatademo.controller;

import com.winter.springdatademo.model.Employee;
import com.winter.springdatademo.repository.EmployeePageAndSortResposiory;
import com.winter.springdatademo.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : EmployeeController  //类名
 * @Description : 雇员  //描述
 * @Author : Winter  //作者
 * @Date: 2020-08-19 17:43  //时间
 */
@Api(value = "雇员操作Api", tags = {"雇员操作管理"})
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeePageAndSortResposiory employeePageAndSortResposiory;

    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public void save(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @ApiOperation(value = "根据姓名查找单个雇员")
    @GetMapping("/find")
    public Employee findByName(String name) {
        return employeeService.findByName(name);
    }


    @ApiOperation(value = "根据id查找")
    @GetMapping("/findById")
    public Employee findById(int id) {
        return employeeService.findById(id);
    }

    @ApiOperation(value = "查询总数")
    @GetMapping("/getCount")
    public int getCount() {
        return employeeService.getCount();
    }

    @ApiOperation(value = "更新")
    @Modifying
    @GetMapping("/update")
    public void updateOneById(int id, String name) {
        employeeService.updateOne(id, name);
    }


    @ApiOperation(value = "批量插入")
    @GetMapping("/saveall")
    public void saveAll() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Employee employee = new Employee();
            employee.setId(i);
            employee.setAge(100 - i);
            employee.setName("name" + i);
            employees.add(employee);
        }
        employeeService.saveAll(employees);
    }


    @ApiOperation(value = "分页")
    @GetMapping("/pageAndSort")
    public Page<Employee> pageList(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize,Sort.Direction.DESC,"id");
        Page<Employee> employeePage = employeePageAndSortResposiory.findAll(pageable);
        return employeePage;
    }

    @ApiOperation(value = "根据年龄条件查找分页")
    @GetMapping("/pageAge")
    public Page<Employee> pageAge(int pageNum, int pageSize,int age) {
        Pageable pageable = PageRequest.of(pageNum, pageSize,Sort.Direction.DESC,"id");
        Page<Employee> employeePage = employeePageAndSortResposiory.findAllByAge(pageable,age);
        return employeePage;
    }


}


