package com.example.EmployerDashboardService.ServiceProxy;

import com.example.EmployerDashboardService.model.EmployeeInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

//@FeignClient(name ="employee-search")
//@RibbonClient(name="employee-search")
public interface EmployeeServiceProxy {
    @RequestMapping("/employee/find/{id}")
    public EmployeeInfo findById(@PathVariable(value = "id") Long id);
    @RequestMapping("/employee/findall")
    public Collection< EmployeeInfo > findAll();
}