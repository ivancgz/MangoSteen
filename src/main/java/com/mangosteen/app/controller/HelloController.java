package com.mangosteen.app.controller;

import com.mangosteen.app.model.dao.UserInfo;
import lombok.val;
import org.springframework.web.bind.annotation.*;

/**
 * Hello Controller
 */
// 对外暴露接口
@RestController
public class HelloController {

    /**
     * Say hello API.
     * @param name name
     * @param id specific id
     * @return hello string
     */
    // 指定路径
    // http://localhost:8080/v1/hello/ivan/123456789
    @GetMapping(path = "v1/hello/{name}/{id}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("id") Long id) {
        return String.format("Hello, %s, %d", name, id);
    }

    //http://localhost:8080/v1/greeting?name=john&id=11008866
    @GetMapping(path = "v1/greeting")
    public String sayGreeting(@RequestParam("name") String name, @RequestParam("id") Long id) {
        val userInfo = UserInfo.builder()
                               .username("xxxx")
                               .build();
        System.out.println(userInfo.getId());
        return String.format("Sqy greeting: %s with %d", name, id);
    }
}
