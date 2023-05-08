package com.study.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yangyanbin
 * @since 20230412
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private static final long serialVersionUID = -5929844276849832922L;
    /**
     * id
     */
    private Long id;
    /**
     * 串行id
     */
    private String serial;
}
