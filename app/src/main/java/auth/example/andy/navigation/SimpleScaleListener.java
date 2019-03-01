package auth.example.andy.navigation;

import android.view.ScaleGestureDetector;
import android.widget.ImageView;

public class SimpleScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    private ImageView mImageView;

    private float mScaleFactor = 1.0f;

    public SimpleScaleListener( ImageView imageView){
        this.mImageView = imageView;
    }

    @Override
    public boolean onScale(ScaleGestureDetector scaleGestureDetector){
        mScaleFactor *= scaleGestureDetector.getScaleFactor();
        mScaleFactor = Math.max(0.1f,
                Math.min(mScaleFactor, 10.0f));
        mImageView.setScaleX(mScaleFactor);
        mImageView.setScaleY(mScaleFactor);
        return true;
    }
}
