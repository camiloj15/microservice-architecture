package com.example.EmployeeSearchService;

import com.google.gson.reflect.TypeToken;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<List<Employee>> handleRequest() {
        //accessing hello-service
        Type founderListType = new TypeToken<ArrayList<Employee>>(){}.getType();

        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                "http://employee-search/employee/findall",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>(){});
        return response;
    }
}