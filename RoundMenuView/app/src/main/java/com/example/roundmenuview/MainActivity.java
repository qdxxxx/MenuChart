package com.example.roundmenuview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.example.roundmenuview.PieChart.MenuChart;
import com.example.roundmenuview.PieChart.PieData;
import com.example.roundmenuview.PieChart.utils.PieUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PieData> mPieDatas = new ArrayList<>();
    // 颜色表
    private int[] mColors = {0xffff6944, 0xff63ff9e, 0xff38474e, 0xff5effdd, 0xffb579ff, 0xfff4ea2a};
    private int[] pieLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        final MenuChart menuChart = (MenuChart) findViewById(R.id.menuChart);
        menuChart.setPieData(mPieDatas);
        menuChart.setStartAngle(180);  //设置起始角度
        menuChart.setPieShowAngle(180);//设置总共角度
        menuChart.setCenterBitmap(R.mipmap.menu, PieUtils.dp2px(MainActivity.this, 60), PieUtils.dp2px(MainActivity.this, 60));
        menuChart.setTouchCenterTextSize(30);
        pieLocation = new int[2];
        findViewById(R.id.btn_click).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (menuChart.getVisibility() == View.GONE) {
                            menuChart.showStartAnim();
                        } else {
                            menuChart.showEndAnim();
                        }
                        return true;

                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_UP:

                        menuChart.getLocationOnScreen(pieLocation);
                        menuChart.onPieTouchEvent(event, event.getRawX() - pieLocation[0], event.getRawY() - pieLocation[1]);

                        return true;
                }


                return false;
            }
        });


    }


    private void initData() {
        PieData pieData = new PieData();
        pieData.setName("不辣，川菜一点都不辣 T_T");
        pieData.setWeight(1);
        pieData.setName_label("CHUAN");
        pieData.setLabelColor(0xffd81e06);
        pieData.setDrawableId(R.mipmap.btm_chuan);
        mPieDatas.add(pieData);


        PieData pieData2 = new PieData();
        pieData2.setName("咸，鲜，清淡");
        pieData2.setWeight(1);
        pieData2.setName_label("YUE");
        pieData2.setDrawableId(R.mipmap.btm_yue);
        pieData2.setLabelColor(0xff90f895);
        mPieDatas.add(pieData2);


        PieData pieData5 = new PieData();
        pieData5.setName("重油盐辣，腊味");
        pieData5.setWeight(1);
        pieData5.setName_label("XIANG");
        pieData5.setDrawableId(R.mipmap.btm_xiang);
        pieData5.setLabelColor(0xffe16531);
        mPieDatas.add(pieData5);

        PieData pieData4 = new PieData();
        pieData4.setName("咸甜");
        pieData4.setWeight(1);
        pieData4.setName_label("MIN");
        pieData4.setDrawableId(R.mipmap.btm_min);
        pieData4.setLabelColor(0xfff5c9cb);
        mPieDatas.add(pieData4);


        PieData pieData3 = new PieData();
        pieData3.setName("甜，黄酒味");
        pieData3.setName_label("SU");
        pieData3.setWeight(1);
        pieData3.setDrawableId(R.mipmap.btm_jiang);
        pieData3.setLabelColor(0xfff4ed61);
        mPieDatas.add(pieData3);

        PieData pieData6 = new PieData();
        pieData6.setName("鲜，浓油赤酱");
        pieData6.setWeight(1);
        pieData6.setName_label("LU");
        pieData6.setDrawableId(R.mipmap.btm_lu);
        pieData6.setLabelColor(0xff944a48);
        mPieDatas.add(pieData6);

    }


    // 闽 f5c9cb  川d81e06  粤90f895    鲁90f895  苏#f4ed61   湘菜#e16531
}
