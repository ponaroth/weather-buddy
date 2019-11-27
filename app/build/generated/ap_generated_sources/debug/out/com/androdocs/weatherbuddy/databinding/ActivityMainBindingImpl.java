package com.androdocs.weatherbuddy.databinding;
import com.androdocs.weatherbuddy.R;
import com.androdocs.weatherbuddy.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.today_textView, 1);
        sViewsWithIds.put(R.id.date_textView, 2);
        sViewsWithIds.put(R.id.hamburgermenu, 3);
        sViewsWithIds.put(R.id.androidAvatar, 4);
        sViewsWithIds.put(R.id.overviewContainer, 5);
        sViewsWithIds.put(R.id.address, 6);
        sViewsWithIds.put(R.id.temp, 7);
        sViewsWithIds.put(R.id.status, 8);
        sViewsWithIds.put(R.id.minTemp, 9);
        sViewsWithIds.put(R.id.maxTemp, 10);
        sViewsWithIds.put(R.id.wind, 11);
        sViewsWithIds.put(R.id.humidity, 12);
        sViewsWithIds.put(R.id.horizontalScroll, 13);
        sViewsWithIds.put(R.id.loader, 14);
        sViewsWithIds.put(R.id.errorText, 15);
        sViewsWithIds.put(R.id.day1, 16);
        sViewsWithIds.put(R.id.day2, 17);
        sViewsWithIds.put(R.id.day3, 18);
        sViewsWithIds.put(R.id.day4, 19);
        sViewsWithIds.put(R.id.day5, 20);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[6]
            , (com.example.weatherbuddy.MyImageView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[15]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.HorizontalScrollView) bindings[13]
            , (android.widget.TextView) bindings[12]
            , (android.widget.ProgressBar) bindings[14]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[11]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.avatarViewModel == variableId) {
            setAvatarViewModel((com.example.weatherbuddy.AvatarViewModel) variable);
        }
        else if (BR.myImageView == variableId) {
            setMyImageView((com.example.weatherbuddy.MyImageView) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setAvatarViewModel(@Nullable com.example.weatherbuddy.AvatarViewModel AvatarViewModel) {
        this.mAvatarViewModel = AvatarViewModel;
    }
    public void setMyImageView(@Nullable com.example.weatherbuddy.MyImageView MyImageView) {
        this.mMyImageView = MyImageView;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): avatarViewModel
        flag 1 (0x2L): myImageView
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}