

package com.hirelink.model;

public class Candidate {
    private int candidateId;
    private String name;
    private String email;
    private String position;
    private String status;
    private int referredBy;

    // Constructors
    public Candidate() {}
    public Candidate(String name, String email, String position, int referredBy) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.status = "Pending";
        this.referredBy = referredBy;
    }

    // Getters & Setters
    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getReferredBy() { return referredBy; }
    public void setReferredBy(int referredBy) { this.referredBy = referredBy; }
}
