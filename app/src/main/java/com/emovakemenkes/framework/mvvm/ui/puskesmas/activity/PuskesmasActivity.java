package com.emovakemenkes.framework.mvvm.ui.puskesmas.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.error.ANError;
import com.emovakemenkes.framework.mvvm.BR;
import com.emovakemenkes.framework.mvvm.R;
import com.emovakemenkes.framework.mvvm.ViewModelProviderFactory;
import com.emovakemenkes.framework.mvvm.databinding.ActivityPuskesmasBinding;
import com.emovakemenkes.framework.mvvm.ui.base.BaseActivity;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.adapter.AdapterPuskesmas;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.models.ModelListPuskesmas;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.navigator.PuskesmasNavigator;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.viewmodels.PuskesmasViewModel;

import java.util.List;

import javax.inject.Inject;

public class PuskesmasActivity extends BaseActivity<ActivityPuskesmasBinding, PuskesmasViewModel> implements PuskesmasNavigator {
    @Inject
    ViewModelProviderFactory factory;
    @Inject
    AdapterPuskesmas mAdapter;
    private PuskesmasViewModel mViewModel;
    private ActivityPuskesmasBinding mBinding;
    private int pageNumber = 0;
    private Context mContext;

    public static Intent newIntent(Context context) {
        return new Intent(context, PuskesmasActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_puskesmas;
    }

    @Override
    public PuskesmasViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, factory).get(PuskesmasViewModel.class);
        return mViewModel;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        mViewModel.setNavigator(this);
        mContext = this;
        setSupportActionBar(mBinding.toolbars);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        startShimmer();
        setUpRv();
        mBinding.swipeRefresh.setOnRefreshListener(() -> {
            mBinding.swipeRefresh.setRefreshing(true);
            mViewModel.getListPuskesmas("", "", pageNumber);
        });
        mViewModel.getListPuskesmas("", "", pageNumber);


    }

    private void setUpRv() {
        mAdapter.setmContext(mContext);
        mBinding.rvOvertime.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        mBinding.rvOvertime.setItemAnimator(new DefaultItemAnimator());
        mBinding.rvOvertime.setHasFixedSize(false);
        mBinding.rvOvertime.setAdapter(mAdapter);
    }

    @Override
    public void handleError(Throwable throwable, String TAG) {
        onError(throwable, TAG);
    }

    @Override
    public void handleErrorNetwork(ANError anError, String TAG) {

    }

    @Override
    public void hideShimmer() {
        mBinding.shimmerViewLeave.setVisibility(View.GONE);
        mBinding.rvOvertime.setVisibility(View.VISIBLE);
        if (mBinding.swipeRefresh.isRefreshing()) {
            mBinding.swipeRefresh.setRefreshing(false);
        }
    }

    @Override
    public void startShimmer() {
        mBinding.shimmerViewLeave.setAutoStart(true);
        mBinding.shimmerViewLeave.startShimmerAnimation();
    }

    @Override
    public void ShowMessages(String title, String Messages, int type) {
        if (type == 1) {
            ShowMessages(this, title + "\n" + Messages);
        } else {
            ShowSnackBar(mBinding.root, title + "\n" + Messages);
        }
    }

    @Override
    public void UpdateData(List<ModelListPuskesmas> modelListPuskesmas) {
       if (modelListPuskesmas != null) {
           mAdapter.addItems(modelListPuskesmas);
       }else{
           //empty
       }
       hideShimmer();
    }
}
