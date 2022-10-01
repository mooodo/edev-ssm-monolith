package com.edev.trade.customer.web;

import com.alibaba.fastjson.JSONObject;
import com.edev.trade.customer.entity.Account;
import com.edev.trade.support.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountMvcTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void testSaveAndDelete() throws Exception {
        Long id = 1L;
        Account account = new Account(id,10000D,
                DateUtils.getDate("2020-01-01","yyyy-MM-dd"),null);
        String json = JSONObject.toJSONStringWithDateFormat(account, "yyyy-MM-dd HH:mm:ss");

        mvc.perform(get("/account/removeAccount")
                .param("accountId",id.toString())
        ).andExpect(status().isOk());
        mvc.perform(post("/account/createAccount")
                .content(json).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id.toString()));
        mvc.perform(get("/account/getAccount")
                .param("accountId", id.toString())
        ).andExpect(status().isOk()).andExpect(content().json(json));

        mvc.perform(get("/account/removeAccount")
                .param("id",id.toString())
        ).andExpect(status().isOk());
        mvc.perform(get("/account/getAccount")
                .param("id", id.toString())
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
