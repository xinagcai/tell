package com.example.tell.entity;

import com.flyco.tablayout.listener.CustomTabEntity;

public class TabEntity implements CustomTabEntity {
    public String titles = "";
    public int selectedIcon;
    public int unSelectedIcon;

    public TabEntity(String titles){
        this.titles = titles;
    }

    public TabEntity(int selectedIcon, int unSelectedIcon) {
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    public String getTabTitle() {
        return titles;
    }


    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
