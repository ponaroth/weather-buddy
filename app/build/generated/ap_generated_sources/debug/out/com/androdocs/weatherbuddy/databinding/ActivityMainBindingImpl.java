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
        sViewsWithIds.put(R.id.temp, 1);
        sViewsWithIds.put(R.id.androidAvatar, 2);
        sViewsWithIds.put(R.id.hamburgermenu, 3);
        sViewsWithIds.put(R.id.dateText, 4);
        sViewsWithIds.put(R.id.digitalClock, 5);
        sViewsWithIds.put(R.id.overviewContainer, 6);
        sViewsWithIds.put(R.id.address, 7);
        sViewsWithIds.put(R.id.wind, 8);
        sViewsWithIds.put(R.id.humidity, 9);
        sViewsWithIds.put(R.id.loader, 10);
        sViewsWithIds.put(R.id.errorText, 11);
        sViewsWithIds.put(R.id.arrow_up, 12);
        sViewsWithIds.put(R.id.maxTemp, 13);
        sViewsWithIds.put(R.id.arrow_down, 14);
        sViewsWithIds.put(R.id.minTemp, 15);
        sViewsWithIds.put(R.id.imageView2, 16);
        sViewsWithIds.put(R.id.status, 17);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[7]
            , (com.example.weatherbuddy.MyImageView) bindings[2]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextClock) bindings[5]
            , (android.widget.TextView) bindings[11]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[9]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ProgressBar) bindings[10]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[8]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
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