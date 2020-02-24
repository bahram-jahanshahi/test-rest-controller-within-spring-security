package ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security/basic")
public class BasicSecurityController {
    @GetMapping("/login")
    private Boolean login() {

        return true;
    }
}
