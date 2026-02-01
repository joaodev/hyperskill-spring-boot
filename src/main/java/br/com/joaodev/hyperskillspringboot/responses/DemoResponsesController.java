package br.com.joaodev.hyperskillspringboot.responses;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DemoResponsesController {

    @GetMapping(value = "/demo-plain", produces = "text/plain")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String hello() {
        return "Hello World!";
    }

    @GetMapping(path = "/another-demo")
    public void anotherDemo(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.setContentType("text/plain");
        response.getWriter().write("Hello World!");
    }
}
