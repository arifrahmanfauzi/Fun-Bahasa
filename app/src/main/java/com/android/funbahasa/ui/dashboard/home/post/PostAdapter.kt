package com.android.funbahasa.ui.dashboard.home.post

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.funbahasa.data.model.ResponsePuisi

class PostAdapter(val data : ArrayList<ResponsePuisi>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}