package zx.com.smallicon.view;


import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by zx on 18-1-12.
 */
public class ExplosionUpdateThread extends Thread implements RenderActionInterface {
    private SurfaceHolder mHolder;
    private boolean isRunning = false;

    public ExplosionUpdateThread(SurfaceHolder holder, DropCover dropCover) {
        mHolder = holder;
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
        while (isRunning && isAlive) {
            Canvas canvas = mHolder.lockCanvas();
            if (canvas != null) {
                isAlive = CoverManager.getInstance().render(canvas);
                mHolder.unlockCanvasAndPost(canvas);
                CoverManager.getInstance().updateExplosion();
            }
        }
        CoverManager.getInstance().removeViews();
    }


}
