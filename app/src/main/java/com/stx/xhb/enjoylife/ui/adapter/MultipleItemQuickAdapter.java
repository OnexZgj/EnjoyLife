package com.stx.xhb.enjoylife.ui.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.stx.xhb.enjoylife.model.entity.VideoResponse;
import com.stx.xhb.enjoylife.ui.adapter.provider.TextItenProvider;
import com.stx.xhb.enjoylife.ui.adapter.provider.VideoItemProvider;

import java.util.List;

/**
 * @author: xiaohaibin.
 * @time: 2018/5/28
 * @mail:xhb_199409@163.com
 * @github:https://github.com/xiaohaibin
 * @describe:
 */
public class MultipleItemQuickAdapter extends MultipleItemRvAdapter<VideoResponse.IssueListEntity.ItemListEntity, BaseViewHolder> {

    public static final int VIDEO = 1;
    public static final int TEXT = 2;
    private VideoItemProvider.setOnItemClickListener mItemClickListener;

    public MultipleItemQuickAdapter(List<VideoResponse.IssueListEntity.ItemListEntity> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(VideoResponse.IssueListEntity.ItemListEntity itemListEntity) {
        if ("video".equals(itemListEntity.getType())) {
            return VIDEO;
        } else /*if (itemListEntity.getType().startsWith("text"))*/ {
            return TEXT;
        }
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new TextItenProvider());
        VideoItemProvider videoItemProvider = new VideoItemProvider();
        mProviderDelegate.registerProvider(videoItemProvider);
        videoItemProvider.setItemClickListener(new VideoItemProvider.setOnItemClickListener() {
            @Override
            public void onItemClick(View view, VideoResponse.IssueListEntity.ItemListEntity data) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(view, data);
                }
            }
        });
    }

    public void setItemClickListener(VideoItemProvider.setOnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

}
