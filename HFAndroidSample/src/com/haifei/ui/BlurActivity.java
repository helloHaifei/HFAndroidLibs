package com.haifei.ui;

import com.zhf.util.FastBlur;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 	TextView span例子
 * 
 * @author: Haifei
 * @data：2014-3-25
 * @blog:http://blog.csdn.net/hellohaifei
 * 
 */
public class BlurActivity extends Activity {
	ImageView imageview;
	Bitmap b ;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout root = new LinearLayout(this);
		setContentView(root);

		imageview = new ImageView(this);
		imageview.setLayoutParams(new LayoutParams(400, 600));
		imageview.setBackgroundResource(R.drawable.blur_image);
		root.addView(imageview);
		
		b = BitmapFactory.decodeResource(getResources(), R.drawable.blur_image);
		//blur(b, imageview);
		
		imageview.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
            	imageview.getViewTreeObserver().removeOnPreDrawListener(this);
            	imageview.buildDrawingCache();

                //Bitmap bmp = btn1.getDrawingCache();
                blur(b, imageview);
                return true;
            }
        });
	}
	
	private void blur(Bitmap bkg, ImageView view) {
        long startMs = System.currentTimeMillis();
        float scaleFactor = 1;
        float radius = 20;
        if (false) {
            scaleFactor = 8;
            radius = 20;
        }

        Bitmap overlay = Bitmap.createBitmap((int) (view.getMeasuredWidth()/scaleFactor),
                (int) (view.getMeasuredHeight()/scaleFactor), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(overlay);
        canvas.translate(-view.getLeft()/scaleFactor, -view.getTop()/scaleFactor);
        canvas.scale(1 / scaleFactor, 1 / scaleFactor);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(bkg, 0, 0, paint);
        overlay = FastBlur.doBlur(overlay, (int)radius, true);
        //view.setImageBitmap(overlay);
        view.setBackgroundDrawable(new BitmapDrawable(overlay));
        //statusText.setText(System.currentTimeMillis() - startMs + "ms");
    }
	

}