package com.gaming.DAO;

import com.gaming.CSDL.Gaming;
import com.gaming.ITF.ITFmachine;
import com.gaming.model.Machine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MachineDAO implements ITFmachine {

    Gaming gaming = new Gaming();
    private void intnit(){
        gaming = new Gaming();
    }


    @Override
    public void insert(Machine machine) throws SQLException {
        System.out.println(gaming.INSERT_CLIENT_SQL);
        try(Connection connection  = gaming.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(gaming.INSERT_CLIENT_SQL)){
            preparedStatement.setInt(1,machine.getIdMachine());
            System.out.println(preparedStatement);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Machine select(int idMachine) throws SQLException {
        Machine machine = null;
        try(Connection connection = gaming.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(gaming.SELECT_CLIENT_UBY_ID)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String nameMachine = rs.getString("nameMachine");
                machine = new Machine(idMachine,nameMachine);
            }
        }

        return machine;
    }

    @Override
    public List<Machine> selectAll() throws SQLException {
        List<Machine> machineList = new ArrayList<>();
        try(Connection  connection = gaming.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(gaming.SELECT_ALL_CLIENT)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("idMachine");
                String nameMachine = rs.getString("nameMachine");
                machineList.add(new Machine(id,nameMachine));
            }
        }
        return machineList;
    }

    @Override
    public boolean delete(int idMachine) throws SQLException {
        boolean rowDelete;
        try(Connection connection = gaming.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(gaming.DELETE_CLIENT_SQL)){
            System.out.println(preparedStatement);
            preparedStatement.setInt(1,idMachine);
            rowDelete = preparedStatement.executeUpdate() >0 ;
        }
        return rowDelete;
    }

    @Override
    public boolean update(Machine machine) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = gaming.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(gaming.UPDATE_CLIENT_SQL)){
            System.out.println(preparedStatement);
//            preparedStatement.setInt(1,);
            rowUpdate = preparedStatement.executeUpdate() >0 ;
        }
        return rowUpdate;
    }
}
