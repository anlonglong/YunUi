package an.along.com.yunyue.main.bean;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;

import java.io.Serializable;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/10 11:41
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class TitleBean implements Serializable {
    @DrawableRes
    private  int selectedId;
    @DrawableRes
    private  int unSelectedId;

    public TitleBean( @DrawableRes int selectedId,  @DrawableRes int unSelectedId) {
        this.selectedId = selectedId;
        this.unSelectedId = unSelectedId;
    }

    @DrawableRes
    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    @DrawableRes
    public int getUnSelectedId() {
        return unSelectedId;
    }

    public void setUnSelectedId(int unSelectedId) {
        this.unSelectedId = unSelectedId;
    }
}
