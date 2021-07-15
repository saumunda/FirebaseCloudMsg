package com.saurabhbhola.centurion;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.saurabhbhola.centurion.Fragment.FirstFragment;
import com.saurabhbhola.centurion.Fragment.SecondFragment;
import com.saurabhbhola.centurion.Fragment.ThirdFragment;

public class ViewpagerAdapter extends FragmentStateAdapter {
    public ViewpagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewpagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewpagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
