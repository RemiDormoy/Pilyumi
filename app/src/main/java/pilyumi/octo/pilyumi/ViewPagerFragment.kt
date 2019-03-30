package pilyumi.octo.pilyumi

import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.fragment_did_you_know.view.*
import kotlinx.android.synthetic.main.fragment_feelings.view.*


class ViewPagerFragment(private val position: Int) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val layout = when (position) {
            1 -> R.layout.fragment_awards
            2 -> R.layout.fragment_streak
            else -> R.layout.fragment_did_you_know
        }
        val inflate = inflater.inflate(layout, container, false)
        if (position == 3) {
            configureForFeelings(inflate)
        } else if (position == 0) {
            inflate.buttonquizz.setOnClickListener {
                startActivity(Intent(requireContext(), QuizzActivity::class.java))
            }
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
                    inflate.sickImageView,
                    inflate.cryingImageView8,
                    inflate.spmImageView,
                    inflate.textView9,
                    inflate.textView10,
                    inflate.textView11,
                    inflate.textView12).forEach {
                    it.animate().alpha(0f).setDuration(300).withEndAction {
                        lottie.playAnimation()
                    }.start()
                }
            }
        }
    }
}