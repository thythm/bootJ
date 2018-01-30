package com.momo.goods.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2018-01-08
 */
@Data
@TableName("goods_brand")
public class GoodsBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	private Long id;
    /**
     * 品牌名称
     */
	private String name;
    /**
     * 0新建、1有效、9作废
     */
	private Integer state;
    /**
     * 备注
     */
	private String remark;
    /**
     * 插入时间
     */
	private Date logTime;

}
