package com.james.curly.presentation.search_detail

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridSpaceItemDecoration(private val space:Float,private val includeEdge:Boolean = false,private val verticalSpace:Float = 0f):RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.setEmpty()

        val position = parent.getChildAdapterPosition(view).takeIf { it != RecyclerView.NO_POSITION } ?: run {
            return
        }
        val layoutManager = parent.layoutManager as? GridLayoutManager ?: throw IllegalArgumentException("not matched layout manager type")

        val spanCount = layoutManager.spanCount
        val column = position % spanCount

        if(includeEdge){
            outRect.left = (space - column * space/spanCount).toInt()
            outRect.right = ((column + 1) * space / spanCount).toInt()

            if(position < spanCount){
                if(verticalSpace > 0){
                    outRect.top = verticalSpace.toInt()
                }else{
                    outRect.top = space.toInt()
                }
            }
        }else{
            outRect.left = (column * space / spanCount).toInt()
            outRect.right = (space - (column + 1)).toInt()
            if(position >= spanCount){
                if(verticalSpace > 0){
                    outRect.top = verticalSpace.toInt()
                }else{
                    outRect.top = space.toInt()
                }
            }
        }

//        val n = layoutManager.spanSizeLookup.getSpanSize(position) // spanSizeLookUp 을 이용하여 spanSize 를 가져오면됨
//        val k = layoutManager.spanSizeLookup.getSpanIndex(position,layoutManager.spanCount) // spanSizeLookUp 을 이용하여 spanIndex 를 가져오면됨
//
//        if(position % layoutManager.spanCount == 0 && edgeSpace > 0){
//            outRect.left = edgeSpace.toInt()
//        }else{
//            outRect.left = (k * space / n).toInt()
//        }
//
//        if(position % layoutManager.spanCount == layoutManager.spanCount -1 && edgeSpace > 0){
//            outRect.right = edgeSpace.toInt()
//        }else{
//            outRect.right = (space - (k + 1) * space / n).toInt()
//        }

    }
}