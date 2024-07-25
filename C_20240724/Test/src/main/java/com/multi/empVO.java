package com.multi;

public class empVO {
    private int id;
    private String name;
    private int age;
    private String office;
    private String phone;

    public empVO() {}

    public empVO(int id, String name, int age, String office, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.office = office;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "empVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", office='" + office + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
