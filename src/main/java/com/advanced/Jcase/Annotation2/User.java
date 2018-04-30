package com.advanced.Jcase.Annotation2;

@Table("user")
public class User {
    @Column("id")
    private int id;

    @Column("user_name")
    private String userName;

    @Column("nick_name")
    private String nickName;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setUserName(String s) {
        this.userName = s;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setNickName(String s) {
        this.nickName = s;
    }

    public String getNickName() {
        return this.nickName;
    }
}
