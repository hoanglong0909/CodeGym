package com.gaming.ITF;

import com.gaming.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ITFclient {
    void insert(Client client)throws SQLException;
    Client select(int idClient)throws SQLException;
    List<Client> selectAll()throws SQLException;
    boolean delete(int idClient)throws SQLException;
    boolean update(Client client)throws SQLException;

    List<Client> listWithMachine() throws SQLException;



}
