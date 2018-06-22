package demo.lon.com.commonlibrary.utils;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/25 12:27
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class CommonUtil {

    public static <T> T checkNotNull(T t) {
        if (null == t) {
            throw new NullPointerException("该参数不能为null : "+t.getClass());
        }
        return t;
    }

}
