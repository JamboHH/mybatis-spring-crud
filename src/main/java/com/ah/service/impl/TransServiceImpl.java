package com.ah.service.impl;

import com.ah.dao.TransDao;
import com.ah.pojo.Trans;
import com.ah.service.TransService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("transService")
public class TransServiceImpl implements TransService {
    @Resource
    private TransDao transDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transMoney(Trans trans) {
        transDao.receiveMoney(trans);
        transDao.addMoney(trans);
    }
}
