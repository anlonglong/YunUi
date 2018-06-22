package demo.lon.com.commonlibrary.baseActivity;

import android.support.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/24 15:31
 * <p>
 * Email: anlonglong0721@gmail.com
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
@IntDef(value = {ClassType.VIEW_MODULE,ClassType.PRESENTER})
public @interface ClassType {
    public static int VIEW_MODULE = 0x01;
    public static int PRESENTER = 0x00;

}
