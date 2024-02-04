package com.example.covid_19track.util;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;


import com.example.covid_19track.data.Model.CovidCountry;

import java.util.List;

public class DiffUtilCallBacksForMainActivity extends DiffUtil.Callback {

    private final List<CovidCountry> OldList;
    private final List<CovidCountry> NewList;

    public DiffUtilCallBacksForMainActivity(List<CovidCountry> oldList, List<CovidCountry> newList) {
        OldList = oldList;
        NewList = newList;
    }

    @Override
    public int getOldListSize() {
        return OldList != null ? OldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return NewList != null ? NewList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return OldList.get(oldItemPosition).getCountry() == NewList.get(newItemPosition).getCountry();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final CovidCountry oldCrew = OldList.get(oldItemPosition);
        final CovidCountry newCrew = NewList.get(newItemPosition);
        return oldCrew.getCountry().equals(newCrew.getCountry());
//
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }



}
