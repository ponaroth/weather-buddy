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
        sViewsWithIds.put(R.id.hour1, 14);
        sViewsWithIds.put(R.id.img_hour1, 15);
        sViewsWithIds.put(R.id.temp_hour1, 16);
        sViewsWithIds.put(R.id.hour2, 17);
        sViewsWithIds.put(R.id.img_hour2, 18);
        sViewsWithIds.put(R.id.temp_hour2, 19);
        sViewsWithIds.put(R.id.hour3, 20);
        sViewsWithIds.put(R.id.img_hour3, 21);
        sViewsWithIds.put(R.id.temp_hour3, 22);
        sViewsWithIds.put(R.id.hour4, 23);
        sViewsWithIds.put(R.id.img_hour4, 24);
        sViewsWithIds.put(R.id.temp_hour4, 25);
        sViewsWithIds.put(R.id.hour5, 26);
        sViewsWithIds.put(R.id.img_hour5, 27);
        sViewsWithIds.put(R.id.temp_hour5, 28);
        sViewsWithIds.put(R.id.hour6, 29);
        sViewsWithIds.put(R.id.img_hour6, 30);
        sViewsWithIds.put(R.id.temp_hour6, 31);
        sViewsWithIds.put(R.id.hour7, 32);
        sViewsWithIds.put(R.id.img_hour7, 33);
        sViewsWithIds.put(R.id.temp_hour7, 34);
        sViewsWithIds.put(R.id.hour8, 35);
        sViewsWithIds.put(R.id.img_hour8, 36);
        sViewsWithIds.put(R.id.temp_hour8, 37);
        sViewsWithIds.put(R.id.hour9, 38);
        sViewsWithIds.put(R.id.img_hour9, 39);
        sViewsWithIds.put(R.id.temp_hour9, 40);
        sViewsWithIds.put(R.id.loader, 41);
        sViewsWithIds.put(R.id.errorText, 42);
        sViewsWithIds.put(R.id.day1, 43);
        sViewsWithIds.put(R.id.day2, 44);
        sViewsWithIds.put(R.id.day3, 45);
        sViewsWithIds.put(R.id.day4, 46);
        sViewsWithIds.put(R.id.day5, 47);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 48, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[6]
            , (com.example.weatherbuddy.MyImageView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[43]
            , (android.widget.TextView) bindings[44]
            , (android.widget.TextView) bindings[45]
            , (android.widget.TextView) bindings[46]
            , (android.widget.TextView) bindings[47]
            , (android.widget.TextView) bindings[42]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.HorizontalScrollView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[38]
            , (android.widget.TextView) bindings[12]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[24]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[30]
            , (android.widget.ImageView) bindings[33]
            , (android.widget.ImageView) bindings[36]
            , (android.widget.ImageView) bindings[39]
            , (android.widget.ProgressBar) bindings[41]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[37]
            , (android.widget.TextView) bindings[40]
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