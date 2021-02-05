package com.android.funbahasa.ui.dashboard.home

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.funbahasa.R
import com.android.funbahasa.data.model.Response


class HomeAdapter(val data : List<Response>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>()  {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.tv_Row_title)
        val photo = view.findViewById<ImageView>(R.id.iv_Row)
        val desc = view.findViewById<TextView>(R.id.tv_Row_desc)
        val createdBy = view.findViewById<TextView>(R.id.tv_Row_createdby)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_article, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size ?: 0

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.title.setText(item.title?.rendered)
        holder.desc.setText(Html.fromHtml(item?.excerpt?.rendered))
        holder.photo.setImageResource(R.drawable.splashscreen_funbahasa)
        holder.createdBy.setText("createdBy:\n Imam hasanan")
    }
}