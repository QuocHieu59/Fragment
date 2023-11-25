package com.example.danhba_fragment

data class ItemModel(var name: String, val imageThumb: Int, val imageLarge: Int = 0) {
    var selected: Boolean = false
}