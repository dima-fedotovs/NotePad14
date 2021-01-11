package com.company;

import java.util.Locale;

public class Person extends Record {
    private String firstName;
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        var str = super.toString();
        return String.format("%s; first name: %s; phone: %s", str, firstName, phone);
    }

    @Override
    public void askData() {
        firstName = InputUtils.askString("First name");
        phone = InputUtils.askString("Phone");
    }

    @Override
    public boolean contains(String substr) {
        return super.contains(substr)
                || firstName.toLowerCase().contains(substr)
                || phone.toLowerCase().contains(substr);
    }
}
