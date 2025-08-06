package com.example.renttrack.model;

public class OCRResponse {
    private String name;
    private String dob;
    private String idNumber;

    // Constructors
    public OCRResponse() {}
    public OCRResponse(String name, String dob, String idNumber) {
        this.name = name;
        this.dob = dob;
        this.idNumber = idNumber;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }
}
