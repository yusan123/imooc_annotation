package com.yu.demo;

/**
 * Created by Administrator on 2019/7/10.
 */
@Table("filter")
public class Filter {

    @Column("id")
    private Integer id;
    @Column("user_name")
    private String userName;
    @Column("nick_name")
    private String nickName;
    @Column("age")
    private Integer age;
    @Column("city")
    private String city;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
