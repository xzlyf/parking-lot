package com.xz.parking;

import com.google.gson.Gson;
import com.xz.parking.dao.MenuDao;
import com.xz.parking.entity.po.MenuPo;
import com.xz.parking.service.AdminService;
import com.xz.parking.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class ParkingApplicationTests {

    @Autowired
    MenuDao menuDao;

    @Test
    void contextLoads() {
        List<String> perms = new ArrayList<>();
        perms.add("EMPL");
        perms.add("USER");
        List<MenuPo> menu = menuDao.getMenuByPerms(perms);
        Gson gson = new Gson();
        System.out.println(gson.toJson(menu));
    }


    @Test
    void testRandom() {
        for (int i = 0; i < 50; i++) {
            System.out.println(randomNumber(6));
        }
    }

    public static String randomNumber(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int temp;
        for (int i = 0; i < length; i++) {
            temp = random.nextInt(10);
            if (i == 0 && temp == 0) {
                i--;
                continue;
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}
