package pilyumi.octo.pilyumi

import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.fragment_did_you_know.view.*
import kotlinx.android.synthetic.main.fragment_feelings.view.*


class ViewPagerFragment(private val position: Int, private val streakClicked: () -> Unit) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val layout = when (position) {
            0 -> R.layout.fragment_feelings
            2 -> R.layout.fragment_streak
            else -> R.layout.fragment_did_you_know
        }
        val inflate = inflater.inflate(layout, container, false)
        if (position == 0) {
            configureForFeelings(inflate)
        } else if (position == 1) {
            inflate.buttonquizz.setOnClickListener {
                startActivity(Intent(requireContext(), QuizzActivity::class.java))
            }
        } else if (position == 2) {
            inflate.setOnClickListener { streakClicked() }
        }
        return inflate
    }

    private fun configureForFeelings(inflate: View) {
        val lottie = inflate.lottieViewFeelings
        listOf(
            inflate.coolImageView,
            inflate.cryingImageView8,
            inflate.sickImageView,
            inflate.spmImageView
        ).forEach {
            it.setOnClickListener {
                listOf(
                    inflate.coolImageView,
                    inflate.handStuff,
                    inflate.sickImageView,
                    inflate.moodSubTitle,
                    inflate.moodTitle,
                    inflate.cryingImageView8,
                    inflate.spmImageView).forEach {
                    it.animate().alpha(0f).setDuration(300).withEndAction {
                        lottie.playAnimation()
                    }.start()
                }
            }
        }
    }
}