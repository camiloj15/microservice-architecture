package com.example.EmployerDashboardService.ServiceProxy;

import com.example.EmployerDashboardService.ServiceProxy.EmployeeServiceProxy;
import com.example.EmployerDashboardService.model.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
public class FeignEmployeeInfoController {
/*
    //@Autowired
    EmployeeServiceProxy proxyService;

    @RequestMapping("/dashboard/feign/{myself}")
    public EmployeeInfo findme(@PathVariable Long myself) {
        return proxyService.findById(myself);
    }
    @RequestMapping("/dashboard/feign/peers")
    public Collection< EmployeeInfo > findPeers() {
        return proxyService.findAll();
    }
*/
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/dashboard/feign/peers")
    public EmployeeInfo handleRequest() {
        //accessing hello-service
        EmployeeInfo helloObject =
                restTemplate.getForObject("http://employee-search/employee/findall", EmployeeInfo.class);

        return helloObject;
    }
}