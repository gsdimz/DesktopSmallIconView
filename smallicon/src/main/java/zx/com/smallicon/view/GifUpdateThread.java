package zx.com.smallicon.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.SurfaceHolder;

/**
 * Created by zx on 18-1-12.
 */
public class GifUpdateThread extends Thread implements RenderActionInterface {
    private SurfaceHolder mHolder;
    private boolean isRunning = false;
    public GifRender mGifRender;
    private float mTargetX;
    private float mTargetY;

    public GifUpdateThread(float x, float y, SurfaceHolder holder, Context context, int resourceId) {
        mHolder = holder;

        mGifRender = new GifRender(context);
        mGifRender.setMovieResource(resourceId);

        mTargetX = x;
        mTargetY = y;

    }

    public void actionStart() {
        isRunning = true;
        start();
    }

    public void actionStop() {
        this.isRunning = false;
    }

    @Override
    public void run() {
        boolean isAlive = true;
        long start = System.nanoTime();
        CoverManager coverManager = CoverManager.getInstance();
        while (isRunning && isAlive) {
            Canvas canvas = mHolder.lockCanvas();
            canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            if (canvas != null) {

                long now = android.os.SystemClock.uptimeMillis();

                //TODO

                if (mGifRender.mMovieStart != 0 && now - mGifRender.mMovieStart > mGifRender.getMovie().duration()) {
                    actionStop();
                }
                mGifRender.draw(canvas, mTargetX, mTargetY);
                mHolder.unlockCanvasAndPost(canvas);
            }
        }
        coverManager.removeViews();
    }
}