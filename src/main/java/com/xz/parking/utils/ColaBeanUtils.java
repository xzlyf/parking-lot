package com.xz.parking.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * BeanUtils list的复制工具类
 *
 * @Date: 2021/10/20
 */
public class ColaBeanUtils {
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
        return copyListProperties(sources, target, null);
    }

    /**
     * @author Johnson
     * 使用场景：Entity、Bo、Vo层数据的复制，因为BeanUtils.copyProperties只能给目标对象的属性赋值，却不能在List集合下循环赋值，因此添加该方法
     * 如：List<AdminEntity> 赋值到 List<AdminVo> ，List<AdminVo>中的 AdminVo 属性都会被赋予到值
     * S: 数据源类 ，T: 目标类::new(eg: AdminVo::new)
     * 示例：
     * List<AdminEntity> adminList = ...;
     * List<ArticleVo> articleVoList = ColaBeanUtils.copyListProperties(adminList, AdminVo::new);
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, ColaBeanUtilsCallBack<S, T> callBack) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t);
            if (callBack != null) {
                // 回调
                callBack.callBack(source, t);
            }
            list.add(t);
        }
        return list;
    }
}
