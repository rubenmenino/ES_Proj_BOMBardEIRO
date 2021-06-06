package com.example.esp11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
class Esp11ApplicationTests {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RepositoryENV repo_env;
    @Autowired
    private RepositoryGPS repo_gps;
    @Autowired
    private RepositoryHR repo_hr;

    @Autowired
    private MockMvc mockmvc;

    @Test
    void contextLoads() {
    }

    @Test
    void fileA1_env() {
        System.out.println("File exists");
        File x = new File("src/main/java/com/example/esp11/a1_env.csv");
        assert (x.exists());
    }



    @Test
    public void springBoot() throws Exception {
        System.out.print("Spring");
        this.mockmvc.perform(get("http://localhost:8091/welcome")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getGPSinfo() throws Exception {
        System.out.print("Spring");
        this.mockmvc.perform(get("http://localhost:8091//fighters/gps")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void emptyRepositoryFighterEnv() throws Exception {
        List<FighterENV> cd = (List<FighterENV>) repo_env.findAll();
        assert (cd.size() > 0);
    }






}
