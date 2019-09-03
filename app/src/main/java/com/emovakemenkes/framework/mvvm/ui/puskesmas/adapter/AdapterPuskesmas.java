package com.emovakemenkes.framework.mvvm.ui.puskesmas.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.emovakemenkes.framework.mvvm.R;
import com.emovakemenkes.framework.mvvm.databinding.ItemBlogEmptyViewBinding;
import com.emovakemenkes.framework.mvvm.databinding.ListPuskesmasBinding;
import com.emovakemenkes.framework.mvvm.databinding.ShimmerLoadingViewBinding;
import com.emovakemenkes.framework.mvvm.ui.base.BaseViewHolder;
import com.emovakemenkes.framework.mvvm.ui.feed.blogs.BlogEmptyItemViewModel;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.activity.PuskesmasEntryForm;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.models.ModelListPuskesmas;
import com.emovakemenkes.framework.mvvm.utils.NetworkUtils;
import com.emovakemenkes.framework.mvvm.utils.ViewUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By MHBX
 */
public class AdapterPuskesmas extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    public static final int VIEW_TYPE_LOAD = 2;

    public List<ModelListPuskesmas> videos;
    private Context mContext;
    private OvertimeListener mListener;


    public AdapterPuskesmas(ArrayList<ModelListPuskesmas> suggestedVideos) {
        this.videos = suggestedVideos;
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(mContext.getApplicationContext());
    }


    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getItemCount() {
        if (videos != null && videos.size() > 0) {
            return videos.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (videos != null && !videos.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else if (videos.isEmpty()) {
            return VIEW_TYPE_EMPTY;
        } else if (!isNetworkConnected()) {
            return VIEW_TYPE_EMPTY;
        } else {
            return VIEW_TYPE_LOAD;
        }
    }

    @Override
    public void onBindViewHolder(@NotNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ListPuskesmasBinding listItemLeaveActBinding = ListPuskesmasBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new OvertimeViewHolder(listItemLeaveActBinding);
            case VIEW_TYPE_LOAD:
                ShimmerLoadingViewBinding cartShimmer = ShimmerLoadingViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new AdapterPuskesmas.LoadViewHolder(cartShimmer);
            case VIEW_TYPE_EMPTY:
                ItemBlogEmptyViewBinding blogViewBinding1 = ItemBlogEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new AdapterPuskesmas.EmptyViewHolder(blogViewBinding1);
            default:
                ListPuskesmasBinding defaultList = ListPuskesmasBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new OvertimeViewHolder(defaultList);
        }
    }

    public void addItems(List<ModelListPuskesmas> cartList) {
        videos.addAll(cartList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        videos.clear();
    }

    public void setListener(OvertimeListener listener) {
        this.mListener = listener;
    }

    public interface OvertimeListener {
        void Detail(ModelListPuskesmas video);
    }

    public class OvertimeViewHolder extends BaseViewHolder {
        private ListPuskesmasBinding mBinding;

        public OvertimeViewHolder(ListPuskesmasBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            ModelListPuskesmas model = videos.get(position);
            mBinding.tvPuskesName.setText(model.getDu_nama_puskesmas());
            mBinding.tvPuskesProv.setText(model.getDu_nama_provinsi());
            mBinding.tvPuskesKabkot.setText(model.getDu_nama_kabkota());
            String email = model.getDu_email(), nama_responden = model.getNama_responden(), jabatan = model.getJabatan_responden(), no_hp = model.getHp_responden();
            String status = model.getStatus_evaluasi();
            if (status.equals("1")) {
                mBinding.imvOption.setVisibility(View.GONE);
                mBinding.labelStatusValidasi.setText("SUDAH EVALUASI");
                mBinding.labelStatusValidasi.setBackgroundColor(Color.BLUE);
            } else if (status.equals("2")) {
                mBinding.imvOption.setVisibility(View.GONE);
                mBinding.labelStatusValidasi.setBackgroundColor(Color.GREEN);
                mBinding.labelStatusValidasi.setText("APPROVED");
            } else {
                mBinding.labelStatusValidasi.setText("BELUM EVALUASI");
                mBinding.labelStatusValidasi.setBackgroundColor(mContext.getResources().getColor(R.color.colorOrange));
            }

            mBinding.root.setOnClickListener(v->{
                mContext.startActivity(new Intent(mContext, PuskesmasEntryForm.class));
            });

        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements BlogEmptyItemViewModel.BlogEmptyItemViewModelListener {
        private ItemBlogEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemBlogEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            if (videos.isEmpty() && isNetworkConnected()) {
                mBinding.imageViewEmpty.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_update));
                mBinding.tvMessage.setText(ViewUtils.setValuesOf(mContext, R.string.info_data_not_found, "Puskesmas", ""));
            } else if (!isNetworkConnected()) {
                mBinding.imageViewEmpty.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_cloud_off));
                mBinding.tvMessage.setText(mContext.getString(R.string.no_internet));
            }
            BlogEmptyItemViewModel emptyItemViewModel = new BlogEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {
            notifyDataSetChanged();
            if (mListener != null) {
//                mListener.onRetryClick();
            }
        }
    }
    public static class LoadViewHolder extends BaseViewHolder {
        private ShimmerLoadingViewBinding mBinding;

        public LoadViewHolder(ShimmerLoadingViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            mBinding.shimmerViewCart.startShimmerAnimation();
        }
        
    }

}