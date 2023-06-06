package com.el.model.dto;

public class MemberDTO {
    private String name;
    private int age;
    private String phone;
    private String emial;

    public MemberDTO() {
    }

    public MemberDTO(String name, int age, String phone, String emial) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.emial = emial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", emial='" + emial + '\'' +
                '}';
    }
}
