

package com.hirelink.dao;

import com.hirelink.model.Employee;
import com.hirelink.util.DBConnection;

import java.sql.*;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO() {
        conn = DBConnection.getConnection();
    }

    public boolean registerEmployee(Employee emp) {
        String sql = "INSERT INTO employee(name, email, password) VALUES(?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getPassword());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Employee login(String email, String password) {
        String sql = "SELECT * FROM employee WHERE email=? AND password=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpId(rs.getInt("emp_id"));
                emp.setName(rs.getString("name"));
                emp.setEmail(rs.getString("email"));
                emp.setTotalPoints(rs.getInt("total_points"));
                return emp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
