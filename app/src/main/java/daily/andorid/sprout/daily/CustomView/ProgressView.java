package daily.andorid.sprout.daily.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ProgressView extends View {

    private int left;
    private int top;
    private int right;
    private int bottom;

    private int SHIFT = 100;
    private int GAP = 10;
    private int RAW = 3;
    private int COLUMN = 3;

    private int[] a = {0, 1, 0};
    private int[] b = {1, 0, 0};

    private int x = 0;

    private int[] mark_pos = {1, 1, 1, 0, 1, 2, 0, 0, 1};

    private Paint paint;

    public ProgressView(Context context) {
        super(context);
        init();
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < COLUMN; i++) {

            left = i * SHIFT + GAP;
            right = left + SHIFT - GAP;

            top = 0;
            bottom = 0;

//            Log.d("progress_view", "Index of i: " + i);


            for (int j = 0; j < RAW; j++) {

                if (mark_pos[x] == 1) {
                    paint.setColor(Color.GREEN);
                } else if (mark_pos[x] == 2) {
                    paint.setColor(Color.BLUE);
                } else {
                    paint.setColor(Color.GRAY);
                }

                x++;

                top = j * SHIFT + GAP;
                bottom = top + SHIFT - GAP;

                canvas.drawRect(left, top, right, bottom, paint);

//                Log.d("progress_view", "j: " + j);
            }


        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int desiredWidth = (COLUMN * SHIFT) + GAP;
        int desiredHeight = (RAW * SHIFT) + GAP;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
            Log.d("progress_view", "MS width EXACTLY: " + width);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
            Log.d("progress_view", "MS width AT_MOST: " + width);
        } else {
            //Be whatever you want
            width = desiredWidth;
            Log.d("progress_view", "DEFAULT WIDTH: " + width);
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
            Log.d("progress_view", "MS height EXACTLY: " + height);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
            Log.d("progress_view", "MS height AT_MOST: " + height);
        } else {
            //Be whatever you want
            height = desiredHeight;
            Log.d("progress_view", "DEFAULT HEIGHT: " + height);
        }

        //MUST CALL THIS
        setMeasuredDimension(width, height);

    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.GRAY);

        left = 0;
        top = 0;
        right = left + 50;
        bottom = top + 50;
    }

}
