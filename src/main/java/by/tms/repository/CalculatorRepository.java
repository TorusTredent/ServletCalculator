package by.tms.repository;

import by.tms.entity.Operation;
import by.tms.repository.configs.Configs;
import by.tms.repository.configs.Const;

import java.sql.*;
import java.util.LinkedList;

public class CalculatorRepository extends Configs {

    public void addOperation(Operation operation) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(Const.addOperationQuery)) {
                    prep.setString(1, operation.getNum1());
                    prep.setString(2, operation.getNum2());
                    prep.setString(3, operation.getOperation());
                    prep.setString(4, operation.getResult());
                    prep.setInt(5, operation.getUser_id());
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Operation> getOperationList(int userId) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(Const.getOperationListQuery)) {
                    prep.setInt(1, userId);
                    ResultSet rs = prep.executeQuery();
                    return getList(rs);
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeAllOperations(int userId) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(Const.removeAllOperationsQuery)) {
                    prep.setInt(1, userId);
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private LinkedList<Operation> getList(ResultSet rs) throws SQLException {
        LinkedList<Operation> operationList = new LinkedList<>();
        while (rs.next()) {
            operationList.addLast(new Operation(rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)));
        }
        return operationList;
    }

}
