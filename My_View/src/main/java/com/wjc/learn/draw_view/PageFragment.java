package com.wjc.learn.draw_view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.wjc.learn.R;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.draw_view.draw_1
 * File_NAME : PageFragment
 * Created by WJC on 2017/11/7 13:57
 * Describe : TODO
 */

public class PageFragment extends Fragment {
    @LayoutRes int sampleLayoutRes;
    @LayoutRes int practiceLayoutRes;

    public static PageFragment newInstance(@LayoutRes int sampleLayoutRes , @LayoutRes int practiceLayoutRes){
        PageFragment pageFragment = new PageFragment();

        Bundle args = new Bundle();
        args.putInt("sampleLayoutRes",sampleLayoutRes);
        args.putInt("practiceLayoutRes",practiceLayoutRes);
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page,container,false);

        ViewStub sampleStub = (ViewStub)view.findViewById(R.id.sampleStub);
        sampleStub.setLayoutResource(sampleLayoutRes);
        sampleStub.inflate();

        ViewStub practiceStub =(ViewStub)view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(practiceLayoutRes);
        practiceStub.inflate();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle!=null){
            sampleLayoutRes = bundle.getInt("sampleLayoutRes");
            practiceLayoutRes = bundle.getInt("practiceLayoutRes");
        }
    }
}
