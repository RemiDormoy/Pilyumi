package pilyumi.octo.pilyumi

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class ViewPagerFragment(private val position: Int) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val layout = when (position) {
            1 -> R.layout.fragment_awards
            2 -> R.layout.fragment_feelings
            else -> R.layout.fragment_did_you_know
        }
        return inflater.inflate(layout, container, false)
    }
}