package com.hs.dataselector;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by zhanghaitao on 2017/5/25.
 * <p/>
 * 对话框基类
 */
public abstract class BaseDialog {

    protected Context context;
    protected Dialog dialog;

    public boolean isShow() {
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public void show() {
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        dialog.show();
    }

    public void dismiss() {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.dismiss();
    }
}
