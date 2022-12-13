import helper.DBUtils;

import java.sql.*;

public class Registration {
    private Connection con;

    public Registration() {
        try {
            con = DBUtils.getDbConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    void insert(String firstName, String secondName, String phoneNum, String check) {
        try {
            String insert = "INSERT INTO customers(first_name, second_name, phone,private)" + "VALUES(?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(insert);
            statement.setString(1, firstName);
            statement.setString(2, secondName);
            statement.setString(3, phoneNum);
            statement.setString(4, check);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Registration registration= new Registration();
    }
}