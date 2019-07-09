package com.qf.j1902.vo;

import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * Created by Administrator on 2019/7/4.
 */
@Data
public class MsgResult {
    private int status;
    private String msg;
}
