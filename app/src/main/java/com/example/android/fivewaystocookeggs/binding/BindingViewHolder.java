package com.example.android.fivewaystocookeggs.binding;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    final T mLayoutBinding;

    public BindingViewHolder(T layoutBinding) {
        super(layoutBinding.getRoot());
        mLayoutBinding = layoutBinding;
    }

    public T getBinding() {
        return mLayoutBinding;
    }
}
