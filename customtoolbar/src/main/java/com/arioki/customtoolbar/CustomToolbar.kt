package com.arioki.customtoolbar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

/**
 * Created on : 11/07/20
 * Author     : arioki
 * Name       : Yoga Setiawan
 * GitHub     : https://github.com/arioki
 */
class CustomToolbar : Toolbar {
    private lateinit var viewRoot: View
    private var toolbarListener: OnCustomToolbarListener? = null
    private var title: String = ""
    private var enableButtonLeft: Boolean = true
    private var enableButtonRight: Boolean = false

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        initial(context, attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        initial(context, attributeSet)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    private fun initial(context: Context, attributeSet: AttributeSet) {
        initialAttr(context, attributeSet)
        viewRoot = View.inflate(getContext(), R.layout.td_toolbar, null)
        val tvTitle = viewRoot.findViewById<TextView>(R.id.tv_title)
        val bgButtonLeft = viewRoot.findViewById<View>(R.id.bg_button_left)
        val bgButtonRight = viewRoot.findViewById<ImageView>(R.id.bg_button_right)
        val buttonRight = viewRoot.findViewById<ImageView>(R.id.iv_btn_right)
        val buttonLeft = viewRoot.findViewById<ImageView>(R.id.iv_btn_left)

        enableButtonRight(enableButtonRight)
        enableButtonLeft(enableButtonLeft)

        viewRoot.layoutParams =
            LayoutParams(LayoutParams.MATCH_PARENT, getActionBarHeight())
        tvTitle?.text = title

        if (childCount == 0) addView(viewRoot)
        buttonLeft.setOnClickListener {
            toolbarListener?.onClickButtonLeft()
        }
        bgButtonLeft.setOnClickListener {
            toolbarListener?.onClickButtonLeft()
        }
        buttonRight.setOnClickListener {
            toolbarListener?.onClickButtonRight()
        }
        bgButtonRight.setOnClickListener {
            toolbarListener?.onClickButtonRight()
        }
        setContentInsetsAbsolute(0, 0)
        setContentInsetsRelative(0, 0)
    }

    private fun initialAttr(context: Context, attributeSet: AttributeSet) {
        val a =
            context.theme.obtainStyledAttributes(attributeSet, R.styleable.CustomToolbar, 0, 0)
        try {
            title = a.getString(R.styleable.CustomToolbar_toolbarTitle) ?: ""
            enableButtonLeft = a.getBoolean(R.styleable.CustomToolbar_toolbarEnableButtonLeft, true)
            enableButtonRight =
                a.getBoolean(R.styleable.CustomToolbar_toolbarEnableButtonRight, false)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            a.recycle()
        }
    }

    private fun getActionBarHeight(): Int {
        val ta = context.theme.obtainStyledAttributes(intArrayOf(android.R.attr.actionBarSize))
        return ta.getDimension(0, 0f).toInt()
    }

    fun setOnClickListener(l: OnCustomToolbarListener) {
        toolbarListener = l
    }

    fun setTitle(title: String) {
        val tvTitle = viewRoot.findViewById<TextView>(R.id.tv_title)
        tvTitle.text = title
    }

    fun enableButtonLeft(enable: Boolean) {
        val bgButtonLeft = viewRoot.findViewById<View>(R.id.bg_button_left)
        val buttonLeft = viewRoot.findViewById<ImageView>(R.id.iv_btn_left)

        if (enable) {
            bgButtonLeft.visible()
            buttonLeft.visible()
        } else {
            bgButtonLeft.gone()
            buttonLeft.gone()
        }
    }

    fun enableButtonRight(enable: Boolean) {
        val buttonRight = viewRoot.findViewById<ImageView>(R.id.iv_btn_right)
        if (enable) {
            buttonRight.visible()
        } else {
            buttonRight.gone()
        }
    }

    interface OnCustomToolbarListener {
        fun onClickButtonLeft()
        fun onClickButtonRight()
    }
}
