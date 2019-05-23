package daily.andorid.sprout.daily.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class GitHubLikeProgressView extends View {

    //Rect values
    private int left;
    private int top;
    private int right;
    private int bottom;

    //Rect constants
    private int SIZE = 100;
    private int GAP = 10;
    private int ROW = 3;
    private int COLUMN = 3;

    private int x = 0; //this variable is for tracking array index

    /**
     * @box_pos an array representing each boxes
     * boxes are counted downwards
     *
     * Diffrent array values can be used to draw different colors
     */
    private int[] box_pos = {1, 1, 1, 0, 1, 2, 0, 0, 1};

    //Objects
    private Paint paint;


    //Constructors
    public GitHubLikeProgressView(Context context) {
        super(context);
        init();
    }

    public GitHubLikeProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GitHubLikeProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public GitHubLikeProgressView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //For loop used to draw boxes
        for (int i = 0; i < COLUMN; i++) {

            left = i * SIZE + GAP;
            right = left + SIZE - GAP;

            top = 0;
            bottom = 0;

            for (int j = 0; j < ROW; j++) {

                if (box_pos[x] == 1) {
                    paint.setColor(Color.GREEN);
                } else if (box_pos[x] == 2) {
                    paint.setColor(Color.BLUE);
                } else {
                    paint.setColor(Color.GRAY);
                }

                x++;

                top = j * SIZE + GAP;
                bottom = top + SIZE - GAP;

                canvas.drawRect(left, top, right, bottom, paint);
            }


        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int desiredWidth = (COLUMN * SIZE) + GAP;
        int desiredHeight = (ROW * SIZE) + GAP;

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
