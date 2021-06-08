package com.gaming.ITF;

import com.gaming.model.Money;

import java.sql.SQLClientInfoException;
import java.util.List;

public interface ITFmoney {
    void insert(Money money) throws SQLClientInfoException;
    Money select(int idMoney) throws SQLClientInfoException;
    List<Money> selectAll() throws SQLClientInfoException;
    boolean delete(int idMoney) throws SQLClientInfoException;
    boolean update(Money money) throws SQLClientInfoException;
}
