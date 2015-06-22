package com.example.sati.project1devf.cutomviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by sati on 21/06/2015.
 */
public class CutomTextViewWhatSong extends TextView {
    public CutomTextViewWhatSong(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Pacifico.ttf"));
    }
}
