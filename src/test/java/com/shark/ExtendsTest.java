package com.shark;

/**
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-12-14:22
 * @projectName SharkUtils
 * @packageName com.shark
 */
public class ExtendsTest {
    public static void main(String[] args) {
        StrentS strentS = new StrentS();
        System.out.println(strentS.getName() + strentS.getNo() + strentS.getSex());
    }


}

class Strent{

    private String name;
    private String No;

    public Strent(){
        name = "zhangjian";
        No = "1";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }
}

class StrentS extends Strent {
    private String sex;

    public StrentS(){
        super();
        sex = "男";
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
