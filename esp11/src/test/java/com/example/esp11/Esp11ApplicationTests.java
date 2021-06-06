package com.example.esp11;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.junit.Assert;

@SpringBootTest
class   Esp11ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testHomeController() {
        Controller homeController = new Controller();
        String result = homeController.welcome();
        Assert.assertEquals(result, "ESP11 BOMBEIROS SIGA SIGA");
    }



}
