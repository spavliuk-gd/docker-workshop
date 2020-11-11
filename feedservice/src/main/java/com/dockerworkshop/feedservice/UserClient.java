package com.dockerworkshop.feedservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(name = "userservice")
public interface UserClient {
    class User {
        public UUID uuid;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{userId}")
    User find(@PathVariable UUID userId);
}
