package com.lk.spring.service;

import com.lk.spring.beans.Bean;

@Bean
public class SalaryService {
    public Integer calSalary(Integer experience) {
        return experience * 5000;
    }
}
