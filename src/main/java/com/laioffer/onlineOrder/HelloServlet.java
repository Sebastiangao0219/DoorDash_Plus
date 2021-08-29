package com.laioffer.onlineOrder;

import com.laioffer.onlineOrder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// 根据resource path(end point)来match servlet
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    // 前端传进来的请求              // 返回给前端的结果
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 返回给前端的文件格式
//        response.setContentType("text/html");
        response.setContentType("application/json");



        // 来自Jackson。把java格式的对象转换成json格式的string。这步叫做 serializaiton
        ObjectMapper mapper = new ObjectMapper();
        Customer customer= new Customer();
        customer.setEmail("sun@laioffer.com");
        customer.setPassword("123456");
        customer.setFirstName("rick");
        customer.setLastName("sun");
        customer.setEnabled(true);


        // JSONObject 底层是HashMap
//        JSONObject obj = new JSONObject();
//        obj.put("name", "Sebastian Gao");
//        obj.put("age", "32");
//        obj.put("gender", "male");
//        obj.put("email", "sebastiangao@gmail.com");

        PrintWriter out = response.getWriter();
        out.print(new ObjectMapper().writeValueAsString(customer));

        // Hello
//        String customer = request.getParameter("customer");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + "Hello " + customer + "</h1>");
//        out.println("</body></html>");
    }
    // 前端想要添加，用此方法处理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Read customer information from request body
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String email = jsonRequest.getString("email");
        String firstName = jsonRequest.getString("first_name");
        String lastName = jsonRequest.getString("last_name");
        int age = jsonRequest.getInt("age");
        // Print customer information to IDE console
        System.out.println("Email is: " + email);
        System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);
        System.out.println("Age is: " + age);
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}