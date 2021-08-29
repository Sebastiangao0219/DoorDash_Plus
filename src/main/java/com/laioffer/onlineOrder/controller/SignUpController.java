package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.entity.Customer;
import com.laioffer.onlineOrder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
* Use @Controller to mark a class its role as a web component, so the spring mvc will register the methods which 
* annotated the @RequestMapping.
* */
@Controller
public class SignUpController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST) // match前端发来的请求
    @ResponseStatus(value = HttpStatus.CREATED)// 如果创建成功，返回CREATED给前端，显示201。
    public void signUp(@RequestBody Customer customer) { // @RequestBody 会把传进来的数据生成Customer obj
        
    }
}
