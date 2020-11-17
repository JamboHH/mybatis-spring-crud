package com.ah.dao;

import com.ah.pojo.Trans;
import org.springframework.stereotype.Repository;

@Repository
public interface TransDao {
    void receiveMoney(Trans trans);

    void addMoney(Trans trans);

}
