package pilyumi.octo.pilyumi

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomePagerAdapter(fragmentManager: FragmentManager, private val streakClicker: () -> Unit) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return ViewPagerFragment(position, streakClicker)
    }

    override fun getCount(): Int {
        return 3
    }
}