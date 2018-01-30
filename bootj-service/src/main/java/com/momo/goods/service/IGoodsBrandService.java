package com.momo.goods.service;


import com.baomidou.mybatisplus.service.IService;
import com.momo.goods.entity.GoodsBrand;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2018-01-08
 */
@Transactional
public interface IGoodsBrandService extends IService<GoodsBrand> {

	
}
