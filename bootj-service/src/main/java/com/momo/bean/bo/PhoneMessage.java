package com.momo.bean.bo;

import lombok.Data;

/**
 * @author majunjie
 * @description 发送短信对象
 * @date 2017/10/25 10:49
 */
@Data
public class PhoneMessage {

    String phone;
    String title;
    String content;
    String remark;

}
