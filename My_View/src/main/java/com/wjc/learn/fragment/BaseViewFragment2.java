package com.wjc.learn.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjc.learn.R;
import com.wjc.learn.data.PageModel;

import java.io.Serializable;
import java.util.List;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.view.myview1_1
 * File_NAME : BaseViewFragment
 * Created by WJC on 2017/11/7 15:11
 * Describe : TODO
 */

public class BaseViewFragment2 extends Fragment{

    private TabLayout tabLayout;
    private ViewPager viewPager;

    FragmentPagerAdapter pagerAdapter;

    List<PageModel> pageModels2;

    public static BaseViewFragment2 newInstance(){
        return new BaseViewFragment2();
    }

    public static BaseViewFragment2 newInstance2(List<PageModel> MorePageModel){

        BaseViewFragment2 baseViewFragment = new BaseViewFragment2();

        Bundle args = new Bundle();
        args.putSerializable("MorePageModel2", (Serializable) MorePageModel);
        baseViewFragment.setArguments(args);
        return baseViewFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle!=null){
            pageModels2= (List<PageModel>) bundle.getSerializable("MorePageModel2");
        }

        pagerAdapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels2.get(position);
                return PageFragment.newInstance(pageModel.getSampleLayoutRes(),pageModel.getPracticeLayoutRes());
            }

            @Override
            public int getCount() {
                return pageModels2.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels2.get(position).getTitleRes());
            }
        };
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_view2,container,false);
        viewPager =(ViewPager)view.findViewById(R.id.pager2);
        viewPager.setAdapter(pagerAdapter);

        tabLayout = (TabLayout)view.findViewById(R.id.tab2);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

}
