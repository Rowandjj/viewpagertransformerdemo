package com.taobao.viewpagertransformer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.CubeInTransformer;
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.ToxicBakery.viewpager.transforms.FlipVerticalTransformer;
import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.ToxicBakery.viewpager.transforms.ScaleInOutTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.ToxicBakery.viewpager.transforms.TabletTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutSlideTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutTranformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        Fragment f1 = new Fragment1();
        Fragment f2 = new Fragment2();
        Fragment f3 = new Fragment3();

        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return 3;
            }
        };

        mViewPager.setAdapter(adapter);

        mViewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                float alpha, scale;
//                if (position >= -1 && position <= 1) {
//                    float factor = Math.abs(Math.abs(position) - 1);//0--1
//                    scale = 0.1f * factor + 0.9f;//0.9---1
//                    alpha = 0.4f * factor + 0.6f;//0.6----1
//
//                    page.setAlpha(alpha);
//                    page.setScaleX(scale);
//                    page.setScaleY(scale);
                    page.setTranslationX(position < 0.0F?0.0F:(-page.getWidth()*0.4f) * position);

//                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.AccordionTransformer:
                mViewPager.setPageTransformer(true,new AccordionTransformer());
                break;
            case R.id.BackgroundToForegroundTransformer:
                mViewPager.setPageTransformer(true,new BackgroundToForegroundTransformer());

                break;
            case R.id.CubeInTransformer:
                mViewPager.setPageTransformer(true,new CubeInTransformer());
                break;
            case R.id.CubeOutTransformer:
                mViewPager.setPageTransformer(true,new CubeOutTransformer());
                break;
            case R.id.DefaultTransformer:
                mViewPager.setPageTransformer(true,new DefaultTransformer());
                break;
            case R.id.DepthPageTransformer:
                mViewPager.setPageTransformer(true,new DepthPageTransformer());
                break;
            case R.id.FlipHorizontalTransformer:
                mViewPager.setPageTransformer(true,new FlipHorizontalTransformer());
                break;
            case R.id.FlipVerticalTransformer:
                mViewPager.setPageTransformer(true,new FlipVerticalTransformer());
                break;
            case R.id.ForegroundToBackgroundTransformer:
                mViewPager.setPageTransformer(true,new ForegroundToBackgroundTransformer());
                break;
            case R.id.RotateUpTransformer:
                mViewPager.setPageTransformer(true,new RotateUpTransformer());
                break;
            case R.id.ScaleInOutTransformer:
                mViewPager.setPageTransformer(true,new ScaleInOutTransformer());
                break;
            case R.id.StackTransformer:
                mViewPager.setPageTransformer(true,new StackTransformer());
                break;

            case R.id.TabletTransformer:
                mViewPager.setPageTransformer(true,new TabletTransformer());
                break;
            case R.id.ZoomInTransformer:
                mViewPager.setPageTransformer(true,new ZoomInTransformer());
                break;
            case R.id.ZoomOutSlideTransformer:
                mViewPager.setPageTransformer(true,new ZoomOutSlideTransformer());
                break;
            case R.id.ZoomOutTranformer:
                mViewPager.setPageTransformer(true,new ZoomOutTranformer());
                break;

            case R.id.FLOW:
                mViewPager.setPageTransformer(true,new EasyPagerTransformer(EasyPagerTransformer.TransformType.FLOW));
                break;
            case R.id.DEPTH:
                mViewPager.setPageTransformer(true,new EasyPagerTransformer(EasyPagerTransformer.TransformType.DEPTH));

                break;
            case R.id.ZOOM:
                mViewPager.setPageTransformer(true,new EasyPagerTransformer(EasyPagerTransformer.TransformType.ZOOM));

                break;
            case R.id.ZOOM_2:
                mViewPager.setPageTransformer(true,new EasyPagerTransformer(EasyPagerTransformer.TransformType.ZOOM_2));
                break;
            case R.id.SLIDE_OVER:
                mViewPager.setPageTransformer(true,new EasyPagerTransformer(EasyPagerTransformer.TransformType.SLIDE_OVER));

                break;


        }

        return super.onOptionsItemSelected(item);
    }
}


















