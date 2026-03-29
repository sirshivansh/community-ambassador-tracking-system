package model;

public class Student {
    private String name;
    private String college;
    private Ambassador ambassador;
    private String referralCode;

    public Student(String name, String college, Ambassador ambassador, String referralCode) {
        this.name = name;
        this.college = college;
        this.ambassador = ambassador;
        this.referralCode = referralCode;
    }

    public String getName() {
        return name;
    }

    public String getCollege() {
        return college;
    }

    public Ambassador getAmbassador() {
        return ambassador;
    }

    public String getReferralCode() {
        return referralCode;
    }
}