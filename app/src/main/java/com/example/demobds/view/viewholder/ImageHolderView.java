/*
 * Copyright (c) 2017 Hoang Hiep.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.demobds.view.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.example.demobds.R;
import com.example.demobds.models.BannerModel;
import com.freegeek.android.materialbanner.holder.Holder;

/**
 * Created by hoanghiep on 7/22/17.
 */

public class ImageHolderView implements Holder<BannerModel> {
    private static final String TAG = ImageHolderView.class.getSimpleName();
    private AppCompatImageView imageView;
    private ProgressBar progressBar;
    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner, new FrameLayout(context), false);
        imageView = (AppCompatImageView) view.findViewById(R.id.imageView);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return view;
    }

    @Override
    public void UpdateUI(Context context, int position, BannerModel data) {
        SimpleTarget<Bitmap> simpleTarget = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                progressBar.setVisibility(View.GONE);
                imageView.setImageBitmap(resource);
            }

            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                progressBar.setVisibility(View.GONE);
            }
        };
        Glide.with(context)
                .asBitmap()
                .load(data.getImageUrl())
                .into(simpleTarget);
    }

}
