package demo.lon.com.commonlibrary.application;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/22 11:33
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class MainfestParser {


    private String ModuleConfig = "ModuleConfig";

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<IModuleConfig> parse(Context context) {
        List<IModuleConfig> moduleConfigs = null;
        Objects.requireNonNull(context);
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle metaData = appInfo.metaData;
            if (null != metaData) {
                moduleConfigs =  metaData.keySet()
                                 .stream()
                                 .filter((key) -> ModuleConfig.equals(metaData.get(key)))
                                 //.collect(ArrayList<String>::new, ArrayList::add, ArrayList::addAll);
                                //上面等价于下面的这一句,虽然简洁,但是看起来不好理解,所以改用下面的形式.
                                 .collect(() -> new ArrayList<IModuleConfig>(),
                                         (classNameList,className) ->classNameList.add(parseModule(className)),
                                         (classNameList,newModuleList) ->classNameList.addAll(newModuleList));

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return moduleConfigs;
    }

    private IModuleConfig parseModule(String classForName) {
        Objects.requireNonNull(classForName);
        Class<? extends IModuleConfig> clazz = null;
        try {
            clazz = (Class<? extends IModuleConfig>) Class.forName(classForName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        IModuleConfig iModuleConfig = null;
        try {
            iModuleConfig = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return iModuleConfig;
    }

}
