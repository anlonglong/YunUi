package demo.lon.com.commonlibrary.stateLayout;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/18 16:19
 * <p>
 * Email: anlonglong0721@gmail.com
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface LayoutStateValue {

    public enum State {
        LOADING, EMPTY, ERROR,HIDE_ALL
    }

    State[] state();
}
