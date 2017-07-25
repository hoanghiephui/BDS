package com.example.demobds.ultis;

import android.content.Intent;

import com.example.demobds.R;
import com.example.demobds.view.activity.BaseActivity;
import com.example.demobds.view.activity.MainActivity;
import com.example.demobds.view.activity.maps.SearchMapActivity;

/**
 * Created by hoanghiep on 7/25/17.
 */

public class IntentUltis {
    public static void openSearchMap(BaseActivity baseActivity) {
        baseActivity.startActivity(new Intent(baseActivity, SearchMapActivity.class));
        baseActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    public static void openMainActivity(BaseActivity baseActivity) {
        baseActivity.startActivity(new Intent(baseActivity, MainActivity.class));
        baseActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }
}
