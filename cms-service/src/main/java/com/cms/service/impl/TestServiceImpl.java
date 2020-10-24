package com.cms.service.impl;

import com.cms.dao.mapper.TestMapper;
import com.cms.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 29237
 */
@Service
public class TestServiceImpl implements TestService
{
    @Autowired
    private TestMapper testMapper;

    @Override
    public int count() {
        return testMapper.count();
    }
}
