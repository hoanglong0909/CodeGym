package com.gaming.DAO;

import com.gaming.CSDL.Gaming;
import com.gaming.ITF.ITFclient;
import com.gaming.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements ITFclient {
    Gaming gaming = new Gaming();
    private void intnit(){
        gaming = new Gaming();
    }


    @Override
    public void insert(Client client) throws SQLException {
        System.out.println(gaming.INSERT_CLIENT_SQL);
        try(Connection connection = gaming.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(gaming.INSERT_CLIENT_SQL)){
            preparedStatement.setString(1, client.getNameClient());
            System.out.println(preparedStatement);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Client select(int idClient) throws SQLException {
        Client client = null;
        try(Connection connection = gaming.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(gaming.SELECT_CLIENT_UBY_ID)){
        preparedStatement.setInt(1, Integer.parseInt("idClient"));
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            String nameClient = rs.getString("nameClient");
            client = new Client(idClient,nameClient);
        }
        }catch (SQLException e){
            System.out.println(e);
        }
    return client;
    }

    @Override
    public List<Client> selectAll() throws SQLException {
        List<Client> clientList = new ArrayList<>();
        try(Connection connection = gaming.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(gaming.SELECT_ALL_CLIENT)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("idClient");
                String nameClient = rs.getString("nameClient");
                clientList.add(new Client(id,nameClient));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return clientList;
    }


    @Override
    public boolean delete(int idClient) throws SQLException {
        boolean rowDelete;
        try (Connection connection = gaming.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(gaming.DELETE_CLIENT_SQL)) {
            preparedStatement.setInt(1, idClient);
            rowDelete = preparedStatement.executeUpdate() > 0;

        }
        return rowDelete;
    }

    @Override
    public boolean update(Client client) throws SQLException {
        boolean rowUpdate;
        try(Connection  connection = gaming.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(gaming.UPDATE_CLIENT_SQL)){
            preparedStatement.setInt(1,client.getIdClient());
            preparedStatement.setString(2, client.getNameClient());
            rowUpdate = preparedStatement.executeUpdate()>0;
        }
        return rowUpdate;
    }

    @Override
    public List<Client> listWithMachine() {
        List<Client> clientList = new ArrayList<>();
        try(Connection connection = gaming.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(gaming.SELECT_ALL_CLIENT_WITH_MACHINE)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("idClient");
                String nameClient = rs.getString("nameClient");
                String machineStatus = rs.getString("machineStatus");
                String nameProduct = rs.getString("nameProduct");
                int accountProduct = rs.getInt("accountProduct");
                int accountTime = rs.getInt("accountTime");
                float totalMoney = rs.getFloat("totalMoney");
                System.out.println(totalMoney);
                clientList.add(new Client(id, nameClient, machineStatus, nameProduct, accountProduct, accountTime, totalMoney));
                System.out.println(clientList);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return clientList;
    }


}



