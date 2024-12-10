package com.example.dmsystem.common;

import java.util.HashMap;

import lombok.Data;

@Data
public class QueryPageParam {

    private static int PAGE_SIZE = 20;
    private static int PAGE_NUM = 1;

    private int pageSize = PAGE_SIZE;
    private int pageNum = PAGE_NUM;


    private HashMap<String, Object> param = new HashMap<>();
}
