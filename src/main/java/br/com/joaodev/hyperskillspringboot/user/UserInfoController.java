package br.com.joaodev.hyperskillspringboot.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @PostMapping("/user")
    public String userStatus(@RequestBody UserInfo userInfo) {
        if (userInfo.isEnabled()) {
            return String.format("User %s is enabled", userInfo.getName());
        } else {
            return String.format("User %s is disabled", userInfo.getName());
        }
    }

    @PostMapping("/users")
    public String userStatus(@RequestBody List<UserInfo> userList) {
        return String.format("Users %s are enabled", userList.size());
    }

    @PostMapping(value = "/user-xml", consumes = MediaType.APPLICATION_XML_VALUE)
    public String userStatusToXML(@RequestBody UserInfo user) {
        return String.format("Added User %s", user);
    }
}
