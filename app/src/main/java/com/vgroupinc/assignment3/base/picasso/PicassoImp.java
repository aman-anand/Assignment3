package com.vgroupinc.assignment3.base.picasso;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.utils.Utils;

/**
 * Created by DELL on 12/18/2017.
 */

public class PicassoImp {
    private static final PicassoImp ourInstance = new PicassoImp();

    private PicassoImp() {
    }

    public static PicassoImp getInstance() {

        return ourInstance;
    }

    public void setImage(Object imageKey, final Context context, int position, final ImageView imageView) {
        int color = Utils.color_array[Utils.getColorPosition(position)];

        if (imageKey != null && !TextUtils.isEmpty(String.valueOf(imageKey))&&Utils.checkInternet((Activity) context)) {
            Picasso.with(context)
                    .load(String.valueOf(imageKey))
                    .error(color)
                    .placeholder(color)
                    .into(imageView);
        } else {
            imageView.setImageResource(color);
        }

    }

    /**
     * @param hypable   true for tournament, false for events
     * @param imageKey
     * @param context
     * @param position
     * @param imageView
     */
    public void setImageBackground(String hypable, Object imageKey, final Context context, int position, final ImageView imageView) {
        int color = Utils.color_array[Utils.getColorPosition(position)];
        if (imageKey != null && !TextUtils.isEmpty(String.valueOf(imageKey))&&Utils.checkInternet((Activity) context)) {
            Picasso.with(context)
                    .load(String.valueOf(imageKey))
                    .error(color)
                    .placeholder(color)
                    .into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            imageView.setBackground(new BitmapDrawable(context.getResources(), bitmap));
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {
                            imageView.setBackground(errorDrawable);
                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {
                            imageView.setBackground(placeHolderDrawable);
                        }
                    });
        } else {
            imageView.setBackgroundColor(color);
            imageView.setAlpha(0.8f);
        }
        if (hypable.equals("TOURNAMENT")) {
            //for tournament
            imageView.setImageResource(R.drawable.hype_border);
        } else {
            //for event
            imageView.setImageResource(R.drawable.hype_border_blue);
        }

    }

    public void setImage(String url, Activity activity, ImageView imageView, int image) {
        Picasso.with(activity)
                .load(url)
                .placeholder(image)
                .error(image)
                .into(imageView);
    }
}
