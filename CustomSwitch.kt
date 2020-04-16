package mi.omiseno.handy.utils.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.layout_custom_switch.view.*
import mi.omiseno.handy.R


class CustomSwitch @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val bgCircle0: Drawable? by lazy { ContextCompat.getDrawable(context, R.drawable.bg_circle_0) }
    private val bgCircleOff0: Drawable? by lazy { ContextCompat.getDrawable(context, R.drawable.bg_circle_0_off) }
    private val bgCircle2: Drawable? by lazy { ContextCompat.getDrawable(context, R.drawable.bg_circle_2) }
    private val bgCircleOff2: Drawable? by lazy { ContextCompat.getDrawable(context, R.drawable.bg_circle_2_off) }
    private val bgBody: Drawable? by lazy { ContextCompat.getDrawable(context, R.drawable.bg_body) }
    private val bgBodyOff: Drawable? by lazy { ContextCompat.getDrawable(context, R.drawable.bg_body_off) }
    private val animTranslateLeft: Animation? by lazy { AnimationUtils.loadAnimation(context, R.anim.translate_to_left) }
    private val animTranslateRight: Animation? by lazy { AnimationUtils.loadAnimation(context, R.anim.translate_to_right) }

    var isEnable: Boolean = false
        set(value) {
            //val transCircle0 = circle0.background as TransitionDrawable
            val transCircle2 = circle2.background as TransitionDrawable
            val transBody = rectBody.background as TransitionDrawable
            when (value) {
                true -> {
                    // If you don't want use animation
                    //circle2.background = bgCircle2
                    //rectBody.background = bgBody
                    //transCircle0.startTransition(500)

                    circle0.background = bgCircle0
                    transCircle2.startTransition(500)
                    transBody.startTransition(500)

                    circle0.startAnimation(animTranslateLeft)
                    circle1.startAnimation(animTranslateLeft)
                    circle2.startAnimation(animTranslateLeft)
                }
                else -> {
                    // If you don't want use animation
                    //circle2.background = bgCircleOff2
                    //rectBody.background = bgBodyOff
                    //transCircle0.reverseTransition(500)

                    circle0.background = bgCircleOff0
                    transCircle2.reverseTransition(500)
                    transBody.reverseTransition(500)

                    circle0.startAnimation(animTranslateRight)
                    circle1.startAnimation(animTranslateRight)
                    circle2.startAnimation(animTranslateRight)
                }
            }
            field = value
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_custom_switch, this, true)
        flRoot.setOnClickListener {
            isEnable = isEnable != true
        }
    }
}