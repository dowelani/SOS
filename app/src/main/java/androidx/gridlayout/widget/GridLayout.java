package androidx.gridlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class GridLayout extends View {
    public GridLayout(Context context) {
        this(context, null);
    }

    public GridLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
