package com.zhy.sample.StickyNavLayout;

import android.os.Bundle;

import com.zhy.view.SimpleViewPagerIndicator;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

/**
 * https://blog.csdn.net/lmj623565791/article/details/43649913
 */
public class MainActivity extends FragmentActivity {
	private String[] mTitles = new String[] { "简介", "评价", "相关" };
	private SimpleViewPagerIndicator mIndicator;
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private TabFragment[] mFragments = new TabFragment[mTitles.length];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initDatas();
		initEvents();
	}

	private void initEvents() {
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				mIndicator.scroll(position, positionOffset);
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

	}

	private void initDatas() {
		mIndicator.setTitles(mTitles);

		for (int i = 0; i < mTitles.length; i++) {
			mFragments[i] = (TabFragment) TabFragment.newInstance(mTitles[i]);
		}

		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public int getCount() {
				return mTitles.length;
			}

			@Override
			public Fragment getItem(int position) {
				return mFragments[position];
			}

		};

		mViewPager.setAdapter(mAdapter);
		mViewPager.setCurrentItem(0);
	}

	private void initViews() {
		mIndicator = (SimpleViewPagerIndicator) findViewById(R.id.id_stickynavlayout_indicator);
		mViewPager = (ViewPager) findViewById(R.id.id_stickynavlayout_viewpager);

	}

}
