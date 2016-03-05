package com.example.android.fivewaystocookeggs.binding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class BindingAdapter<T extends ViewDataBinding> extends RecyclerView.Adapter<BindingViewHolder<T>> {

    private final int mLayoutResourceId;

    public BindingAdapter(int layoutResourceId) {
        mLayoutResourceId = layoutResourceId;
    }

    @Override
    public BindingViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        T binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), mLayoutResourceId, parent, false);
        return new BindingViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder<T> holder, int position) {
        T binding = holder.getBinding();
        updateBinding(binding, position);
    }

    protected abstract void updateBinding(T binding, int position);
}
