package com.bitingbit.news.mobileapp.adapters

import android.content.Context
import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bitingbit.news.mobileapp.R
import com.bitingbit.news.mobileapp.fragments.NewsFragment
import com.bitingbit.news.mobileapp.fragments.UserProfileFragment

private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    companion object {
        private val NUMBER_OF_FRAGMENTS = 2
    }

    private val mFragments = SparseArray<Fragment>()

    override fun getCount(): Int {
        return NUMBER_OF_FRAGMENTS
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {

            0 -> {
                NewsFragment()
            }

            1 -> {
                UserProfileFragment()
            }
            else -> getItem(position + 1)
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as Fragment
        mFragments.put(position, fragment)
        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        mFragments.remove(position)
        super.destroyItem(container, position, `object`)
    }

    /**
     * Returns the instance of the fragment if it is created, null otherwise.
     */
    fun getFragment(position: Int): Fragment? {
        return if (mFragments.size() == 0) {
            null
        } else mFragments.get(position)
    }
}