package com.shark.common;

/**
 * 接口回复信息
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-08-14:08
 * @projectName SharkUtils
 * @packageName com.shark.commen
 */
public class Msg {
    private String code;
    private String msg;
    private Object result;

    public Msg(){}

    public Msg(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Msg(Integer code, String msg){
        this.code = code.toString();
        this.msg = msg;
    }

    public Msg(Integer code) {
        this.code = code.toString();
        this.msg = "";
        this.result = "";
    }

    public Msg(Integer code,Object data) {

        this.code = code.toString();

        if(data instanceof String){
            this.msg = (String)data;
            this.result = "";
        }else{
            this.msg = "";
            this.result = data;
        }


    }
    public Msg(Integer code, String msg,Object data) {
        this.code = code.toString();
        this.msg = msg;
        this.result = data;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void buildMsg(String code, String msg, Object result){
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public void buildMsg(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public void  buildMsg(Integer code, String msg){
        this.code = code.toString();
        this.msg = msg;
    }
    @Override
    public String toString() {
        return "Msg [code=" + code + ", msg=" + msg + ", result=" + result + "]";
    }

}
