package com.study.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangyanbin
 * @since 20230412
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{
    /**
     * code编码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}

