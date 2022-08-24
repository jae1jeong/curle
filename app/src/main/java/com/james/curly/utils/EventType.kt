package com.james.curly.utils


sealed class EventType(val type:String){

    object View:EventType(type = "View")
    object Purchase:EventType(type = "Purchase")
    object AddToCart:EventType(type = "AddToCart")
    object Search:EventType(type = "Search")
}
