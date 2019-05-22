package com.example.demo.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 3068837394742385884L;

    private Integer code;

    private String msg;

    //返回的具体内容T
    private T data;

}
