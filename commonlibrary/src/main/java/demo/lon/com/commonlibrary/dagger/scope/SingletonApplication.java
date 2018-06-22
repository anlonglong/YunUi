package demo.lon.com.commonlibrary.dagger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/2/2 10:38
 * <p>
 * Email: anlonglong0721@gmail.com
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface SingletonApplication {
}
