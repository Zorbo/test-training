package org.example;

import java.net.http.HttpResponse;

//@Controller
public interface RestController {

    HttpResponse<UserDto> getPalindromeUser(String userId);
}
