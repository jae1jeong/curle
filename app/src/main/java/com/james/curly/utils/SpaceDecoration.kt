package com.james.curly.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceDecoration(
    private val mTop: Int = 0,
    private val mLeft: Int = 0,
    private val mRight: Int = 0,
    private val mBottom: Int = 0
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            top = mTop
            left = mLeft
            right = mRight
            bottom = mBottom
        }
    }
}