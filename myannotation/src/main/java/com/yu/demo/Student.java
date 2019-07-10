package com.yu.demo;

/**
 * Created by Administrator on 2019/7/10.
 */
@Table("student")
public class Student {

    @Column("id")
    private Integer id;
    @Column("name")
    private String name;
    @Column("age")
    private Integer age;
    @Column("subject")
    private String subject;
    @Column("city")
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

