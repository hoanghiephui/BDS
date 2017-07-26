package com.example.demobds.view.activity.maps;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.demobds.R;
import com.example.demobds.view.activity.BaseActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by hoanghiep on 7/26/17.
 */

public abstract class BaseMapsActivity extends BaseActivity implements OnMapReadyCallback,
        OnMapAndViewReadyListener.OnGlobalLayoutAndMapReadyListener {
    private GoogleMap googleMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            new OnMapAndViewReadyListener(mapFragment, this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (this.googleMap != null) {
            return;
        }
        this.googleMap = googleMap;
        startMaketMap();
    }

    protected abstract void startMaketMap();

    public GoogleMap getGoogleMap() {
        return googleMap;
    }
}
