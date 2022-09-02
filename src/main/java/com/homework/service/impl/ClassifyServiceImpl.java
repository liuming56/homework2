package com.homework.service.impl;


import com.homework.mapper.ClassifyMapper;
import com.homework.pojo.Classify;
import com.homework.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper cm;

    @Override
    public List<Classify> getClassifies() {
        return cm.selectList(null);
    }
}
