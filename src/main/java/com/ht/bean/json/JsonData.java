package com.ht.bean.json;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author roger
 * @date 2020/6/9 15:01
 */
@Service
@Data
public class JsonData<T> {
    private int code=0;
    private String msg="";
    private int count;
    private List<T> data;

}
