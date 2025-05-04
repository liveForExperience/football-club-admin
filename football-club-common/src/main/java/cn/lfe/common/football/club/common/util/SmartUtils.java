package cn.lfe.common.football.club.common.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author chen yue
 * @date 2024-07-03 16:24:57
 */
@Slf4j
public class SmartUtils {
    private SmartUtils() {
    }

    /**
     * <p> 使用空格，在字符串之后补齐对应的字节数长度。
     * <p> 需要注意：
     * <ul>
     *     <li>len对应的并不是字符串长度，而是字符串的字节数组长度。</li>
     *     <li>该方法只会修改字符串的空格数量。</li>
     *     <li>
     *         <p> 若len小于trim后的字符串字节数组长度，则返回trim后的字符串，即字符串长度可能大于len。
     *         <p> example:
     *         <p> ascCode = " 123456 "; len = 4; return "123456"
     *     </li>
     * </ul>
     * @see StrUtil#fillAfter(String, char, int)
     *
     * @param str 指定字符串
     * @param len 字符位数
     * @return 指定长度字符串
     */
    public static String trimAndFillAfter(String str, Integer len) {
        if (StrUtil.isEmpty(str)) {
            return str;
        }

        str = str.trim();
        if (StrUtil.isEmpty(str)) {
            return str;
        }

        return str + StrUtil.repeat(" ", Math.max(len - str.getBytes().length, 0));
    }

    /**
     * 对象或Map转Bean。<br>
     * 依赖hutool实现，做了简单封装。<br/>
     * {@link Map.Entry}中放置的是转换字段之间的映射关系，用于处理字段名不同的情况
     *
     * @param <T>        转换的Bean类型
     * @param source     Bean对象或Map
     * @param targetType 目标的Bean类型
     * @param pairs      转换字段映射
     * @return 目标对象
     */
    @SafeVarargs
    public static <T> T copyToBean(Object source, Class<T> targetType, Map.Entry<String, String>... pairs) {
        if (source == null) {
            return null;
        }

        return BeanUtil.toBean(source, targetType, new CopyOptions().setFieldMapping(MapUtil.ofEntries(pairs)));
    }

    /**
     * 复制集合中的Bean属性。<br>
     * 此方法遍历集合中每个Bean，复制其属性后加入一个新的{@link List}中。<br>
     * 依赖hutool实现，做了简单封装。<br>
     * {@link Map.Entry}中放置的是转换字段之间的映射关系，用于处理字段名不同的情况
     *
     * @param collection 原Bean集合
     * @param targetType 目标Bean类型
     * @param pairs      转换字段映射
     * @param <T>        Bean类型
     * @return 复制后的List
     */
    @SafeVarargs
    public static <T> List<T> copyToList(Collection<?> collection, Class<T> targetType, Map.Entry<String, String>... pairs) {
        if (collection == null) {
            return null;
        }

        return BeanUtil.copyToList(collection, targetType, new CopyOptions().setFieldMapping(MapUtil.ofEntries(pairs)));
    }

    /**
     * 复制集合中的Bean属性。<br>
     * 此方法遍历集合中每个Bean，复制其属性后加入一个新的{@link List}中。<br>
     * 依赖hutool实现，做了简单封装。<br/>
     * {@link Map.Entry}中放置的是转换字段之间的映射关系，用于处理字段名不同的情况
     *
     * @param collection 原Bean集合
     * @param targetType 目标Bean类型
     * @param pairs      转换字段映射
     * @param <T>        Bean类型
     * @return 复制后的List
     */
    @SafeVarargs
    public static <T> List<T> copyToPage(Collection<?> collection, Class<T> targetType, Map.Entry<String, String>... pairs) {
        if (collection == null) {
            return null;
        }

        if (!(collection instanceof Page)) {
            return copyToList(collection, targetType, pairs);
        }

        List<T> list = collection.stream().map((source) -> {
            final T target = ReflectUtil.newInstanceIfPossible(targetType);
            BeanUtil.copyProperties(source, target, new CopyOptions().setFieldMapping(MapUtil.ofEntries(pairs)));
            return target;
        }).collect(new Collector<T, List<T>, List<T>>() {
            @Override
            public Supplier<List<T>> supplier() {
                return Page::new;
            }

            @Override
            public BiConsumer<List<T>, T> accumulator() {
                return List::add;
            }

            @Override
            public BinaryOperator<List<T>> combiner() {
                return (left, right) -> {
                    left.addAll(right);
                    return left;
                };
            }

            @Override
            public Function<List<T>, List<T>> finisher() {
                return i -> (List<T>) i;
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
            }
        });

        ((Page<T>) list).setTotal(((Page<?>) collection).getTotal());
        return list;
    }

    /**
     * 如果入参字符串是null，则返回空字符串，否则返回本身
     *
     * @param str 待处理的字符串
     * @return 处理后的字符串
     */
    public static String ifNullThenBlank(String str) {
        return str == null ? "" : str;
    }

    /**
     * 求和，并以{@link BigDecimal}格式返回
     *
     * @param list      列表
     * @param numberFun 获取数字的方法
     * @param <T>       列表元素
     * @param <N>       列表元素的数字属性
     * @return 总和
     */
    public static <T, N extends Number> BigDecimal sumToBigDecimal(List<T> list, Function<T, N> numberFun) {
        if (CollUtil.isEmpty(list)) {
            return BigDecimal.ZERO;
        }

        BigDecimal ans = BigDecimal.ZERO;
        for (T t : list) {
            ans = NumberUtil.add(numberFun.apply(t), ans);
        }
        return ans;
    }

    /**
     * 获取重复元素
     *
     * @param list   列表
     * @param keyFun 元素唯一键获取方法
     * @param <T>    元素类型
     * @param <K>    唯一键类型
     * @return 重复元素
     */
    public static <T, K> List<K> listDuplicates(List<T> list, Function<T, K> keyFun) {
        if (CollUtil.isEmpty(list)) {
            return new ArrayList<>();
        }

        Set<K> keys = new HashSet<>(), duplicates = new HashSet<>();
        for (T t : list) {
            if (!keys.add(keyFun.apply(t))) {
                duplicates.add(keyFun.apply(t));
            }
        }

        return new ArrayList<>(duplicates);
    }

    /**
     * <p> 字符串转布尔类型
     * <p> 如果为空则返回默认值
     * <p> 如果不能解析为布尔值则返回false
     *
     * @param value        待转换的字符串
     * @param defaultValue 默认值
     * @return 转换结果
     */
    public static boolean toBooleanDefaultIfEmpty(String value, boolean defaultValue) {
        if (StrUtil.isEmpty(value)) {
            return defaultValue;
        }

        return BooleanUtil.toBoolean(value);
    }

    /**
     * 将列表转换为去重的数据结构
     *
     * @param list      列表
     * @param getKeyFun 获取key的fun
     * @param <T>       列表元素类型
     * @param <F>       key的类型
     * @return 生成的set
     */
    public static <T, F> Set<F> toSet(List<T> list, Function<T, F> getKeyFun) {
        if (CollUtil.isEmpty(list)) {
            return new HashSet<>();
        }

        Set<F> set = new HashSet<>();
        for (T t : list) {
            set.add(getKeyFun.apply(t));
        }
        return set;
    }

    /**
     * 获取response对象
     *
     * @return response
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        return requestAttributes.getResponse();
    }
}

