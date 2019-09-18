package com.unforce.detectago.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;
    private List<String> fragmentTitles;
    private List<Integer> fragmentIcons;

    private Context context;

    public ViewPagerAdapter(FragmentManager fragmentManager, Context context)
    {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        this.fragments = new ArrayList<>();
        this.fragmentTitles = new ArrayList<>();
        this.fragmentIcons = new ArrayList<>();

        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        System.out.println("TEST");

        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position

        if(this.fragmentIcons.get(position) != 0)
        {
            Drawable image = ContextCompat.getDrawable(this.context, this.fragmentIcons.get(position));
            image.setBounds(0, 0, 96, 96);
            SpannableString sb = new SpannableString(" ");
            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return sb;
        }

        return this.fragmentTitles.get(position);
    }

    public void addFragment(@NonNull Fragment fragment, String title, int icon)
    {
        this.fragments.add(fragment);
        this.fragmentTitles.add(title);
        this.fragmentIcons.add(icon);
    }
}
