package com.hirelink.dao;

import com.hirelink.model.Candidate;
import com.hirelink.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
    private Connection conn = DBConnection.getConnection();

    public boolean addCandidate(Candidate c) {
        String sql = "INSERT INTO candidate(name, email, position, status, referred_by) VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPosition());
            ps.setString(4, c.getStatus());
            ps.setInt(5, c.getReferredBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public List<Candidate> getAllCandidates() {
        List<Candidate> list = new ArrayList<>();
        String sql = "SELECT * FROM candidate";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Candidate c = new Candidate();
                c.setCandidateId(rs.getInt("candidate_id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPosition(rs.getString("position"));
                c.setStatus(rs.getString("status"));
                c.setReferredBy(rs.getInt("referred_by"));
                list.add(c);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public boolean updateStatus(int id, String status) {
        String sql = "UPDATE candidate SET status=? WHERE candidate_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}
