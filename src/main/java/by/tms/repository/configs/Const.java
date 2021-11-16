package by.tms.repository.configs;

public class Const {
    public static final String addUserQuery = "INSERT INTO user (name, username, password, status) VALUES (?, ?, ?, ?)";
    public static final String checkUsernameQuery = "SELECT * FROM user WHERE username = ?";
    public static final String checkPasswordQuery = "SELECT * FROM user WHERE password = ? AND username = ?";
    public static final String getUserQuery = "SELECT * FROM user WHERE username = ?";
    public static final String changeNameQuery = "UPDATE user SET name = ? WHERE id = ?";
    public static final String changePasswordQuery = "UPDATE user SET password = ? WHERE id = ?";
    public static final String deleteUserQuery = "DELETE FROM user WHERE id = ?";
    public static final String getUserListQuery = "SELECT * FROM user";
    public static final String addAdminStatus = "UPDATE user SET status = 'admin' WHERE id = ?";
    public static final String removeAdminStatus = "UPDATE user SET status = 'user' WHERE id = ?";


    public static final String addOperationQuery = "INSERT INTO operations (num1, num2, operation, result, user_id) " +
                                                        "VALUES (?,?,?,?,?)";
    public static final String getOperationListQuery = "SELECT num1, num2, operation, result FROM" +
                                                            " operations WHERE user_id = ?";
    public static final String removeAllOperationsQuery = "DELETE FROM operations WHERE user_id = ?";



    public static final String USER_TABLE = "user";

    public static final String USER_ID = "id";
    public static final String USER_FIRSTNAME = "name";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";


    public static final String OPERATIONS_TABLE = "operations";

    public static final String OPERATIONS_ID = "id";
    public static final String OPERATIONS_NUM1 = "num1";
    public static final String OPERATIONS_NUM2 = "num2";
    public static final String OPERATIONS_OPERATION = "operation";
    public static final String OPERATIONS_RESULT = "result";
    public static final String OPERATIONS_USER_ID = "user_id";




//    String addUserQuery = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + ", " +
//            Const.USER_USERNAME + ", " + Const.USER_PASSWORD + ") " + "VALUES (?, ?, ?)";
//    String checkUsernameQuery = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_USERNAME + " = ?";
//    String checkPasswordQuery = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_PASSWORD + " = ? AND " +
//        Const.USER_USERNAME + " = ?";
//    String getUserQuery = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_USERNAME + " = ?";
//    String changeNameQuery = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_FIRSTNAME +
//        " = ? WHERE " + Const.USER_ID + " = ?";
//    String changePasswordQuery = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_PASSWORD +
//        " = ? WHERE " + Const.USER_ID + " = ?";
//    String deleteUserQuery = "DELETE FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID + " = ?";
//    String addOperationQuery = "INSERT INTO " + Const.OPERATIONS_TABLE + "(" + Const.OPERATIONS_NUM1 + ", " +
//        Const.OPERATIONS_NUM2 + ", " + Const.OPERATIONS_OPERATION + ", " + Const.OPERATIONS_RESULT +
//        ", " + Const.OPERATIONS_USER_ID + ") " + "VALUES (?, ?, ?, ?, ?)";
//    String getOperationListQuery = "SELECT " + Const.OPERATIONS_NUM1 + ", " + Const.OPERATIONS_NUM2 + ", "
//        + Const.OPERATIONS_OPERATION + ", " + Const.OPERATIONS_RESULT +
//        " FROM " + Const.OPERATIONS_TABLE + " WHERE " + Const.OPERATIONS_USER_ID + " = ?";
//    String removeAllOperationsQuery = "DELETE FROM " + Const.OPERATIONS_TABLE +
//        " WHERE " + Const.OPERATIONS_USER_ID + " = ?";
}
