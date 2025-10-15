

package com.hirelink.model;

public class Employee {
    private int empId;
    private String name;
    private String email;
    private String password;
    private int totalPoints;

    public Employee() {}

    public Employee(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.totalPoints = 0;
    }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getTotalPoints() { return totalPoints; }
    public void setTotalPoints(int totalPoints) { this.totalPoints = totalPoints; }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
