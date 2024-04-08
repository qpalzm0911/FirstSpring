package com.example.first.Controller;

import org.springframework.web.bind.annotation.*;

class HelloRequest{
    private Long userId;
    private String password;

    public Long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/{helloId}")
    public String sayHello(
            @PathVariable Long helloId,
            @RequestParam String message
    ){
        return helloId.toString() + ", " + message;
    }

    @PostMapping
    public String sayHelloPost(
            @RequestBody HelloRequest body
    ){
        return body.getUserId()+ " , " + body.getPassword();
    }

    @PutMapping
    public String sayHelloPut(){
        return "Hello Put";
    }

    @DeleteMapping String sayHelloDelete(){
        return "Hello Delete";
    }

}
