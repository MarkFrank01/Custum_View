package com.wjc.learn.data;

import com.wjc.learn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Project_NAME : Costum_View
 * Package_NAME : com.wjc.learn.data
 * File_NAME : MorePages
 * Created by WJC on 2017/11/16 17:03
 * Describe : TODO
 */

public class MorePages {


    //1.1 绘制基础
    public static List<PageModel> draw_basal() {
        List<PageModel> pageModels = new ArrayList<>();
        {
            pageModels.add(new PageModel(R.layout.sample_color, R.layout.draw_basal_practice_color, R.string.title_draw_color));
            pageModels.add(new PageModel(R.layout.sample_circle, R.layout.draw_basal_practice_circle, R.string.title_draw_circle));
            pageModels.add(new PageModel(R.layout.sample_rect, R.layout.draw_basal_practice_rect, R.string.title_draw_rect));
            pageModels.add(new PageModel(R.layout.sample_point,R.layout.draw_basal_practice_point,R.string.title_draw_point));
            pageModels.add(new PageModel(R.layout.sample_oval,R.layout.draw_basal_practice_oval,R.string.title_draw_oval));
            pageModels.add(new PageModel(R.layout.sample_line,R.layout.draw_basal_practice_line,R.string.title_draw_line));
            pageModels.add(new PageModel(R.layout.sample_round_rect,R.layout.draw_basal_practice_round_rect,R.string.title_draw_round_rect));
            pageModels.add(new PageModel(R.layout.sample_arc,R.layout.draw_basal_practice_arc,R.string.title_draw_arc));
            pageModels.add(new PageModel(R.layout.sample_path,R.layout.draw_basal_path,R.string.title_draw_path));
            pageModels.add(new PageModel(R.layout.sample_histogram,R.layout.draw_basal_histogram,R.string.title_draw_histogram));
            pageModels.add(new PageModel(R.layout.sample_pie_chart,R.layout.draw_basal_pie_chart,R.string.title_draw_pie_chart));
        }
        return pageModels;
    }

}
