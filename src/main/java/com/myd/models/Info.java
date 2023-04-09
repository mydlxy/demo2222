package com.myd.models;

import lombok.Data;

import java.util.List;

/**
 * @author myd
 * @date 2023/4/5  10:18
 */

@Data
public class Info {

    private List<User> users;

    private Dep  dep;
}
