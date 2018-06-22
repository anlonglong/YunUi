package demo.lon.com.commonlibrary.stateLayout;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/18 16:41
 * <p>
 * Email: anlonglong0721@gmail.com
 */

@Retention(RetentionPolicy.SOURCE)
@LayoutStateValue(state = {LayoutStateValue.State.LOADING,
                           LayoutStateValue.State.EMPTY,
                           LayoutStateValue.State.ERROR})
@Target({ElementType.METHOD})
public @interface LayoutState {

}
