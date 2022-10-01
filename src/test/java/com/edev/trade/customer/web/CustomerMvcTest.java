package com.edev.trade.customer.web;

import com.alibaba.fastjson.JSONObject;
import com.edev.trade.customer.entity.Address;
import com.edev.trade.customer.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerMvcTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void testSaveAndDelete() throws Exception {
        Long id = 1L;
        Customer customer = new Customer(id, "John", "male",
                "510212199901012211", "13677778888");
        String json = JSONObject.toJSONStringWithDateFormat(customer, "yyyy-MM-dd HH:mm:ss");

        mvc.perform(get("/customer/delete")
                .param("customerId", id.toString())
        ).andExpect(status().isOk());
        mvc.perform(post("/customer/register")
                .content(json).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id.toString()));
        mvc.perform(get("/customer/load")
                .param("customerId", id.toString())
        ).andExpect(status().isOk()).andExpect(content().json(json));

        customer.setName("Jone");
        customer.setGender("female");
        customer.setIdentification("100101200003052314");
        json = JSONObject.toJSONStringWithDateFormat(customer, "yyyy-MM-dd HH:mm:ss");
        mvc.perform(post("/customer/modify")
                .content(json).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/customer/load")
                .param("customerId", id.toString())
        ).andExpect(status().isOk()).andExpect(content().json(json));

        mvc.perform(get("/customer/delete")
                .param("customerId", id.toString())
        ).andExpect(status().isOk());
        mvc.perform(get("/customer/load")
                .param("customerId", id.toString())
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
