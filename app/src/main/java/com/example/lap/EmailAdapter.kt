package com.example.lap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class EmailAdapter(val messages: ArrayList<EmailModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return messages.size
    }

    override fun getItem(position: Int): Any {
        return messages[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val currentItem = messages[position]

        // Hiển thị dữ liệu tương ứng trong mỗi item
        holder.username.text = currentItem.username
        holder.message.text = currentItem.message
        holder.time.text = currentItem.time

        // Trong hàm getView của EmailAdapter:
        val firstLetter = currentItem.username.first().uppercaseChar().toString()
        holder.avatar.text =
            firstLetter // Sử dụng avatar là một TextView để hiển thị chữ cái in hoa


        // Xử lý hiển thị trạng thái đã chọn
        if (currentItem.selected) {
            holder.selected.setBackgroundResource(R.drawable.yellow_star_background) // Chỉnh màu nền thành màu vàng
        } else {
            holder.selected.setBackgroundResource(R.drawable.white_star_background) // Màu nền mặc định là trắng
        }

        holder.selected.setOnClickListener {
            // Đảo ngược trạng thái selected
            currentItem.selected = !currentItem.selected

            // Cập nhật lại trạng thái cho item hiện tại
            if (currentItem.selected) {
                holder.selected.setBackgroundResource(R.drawable.yellow_star_background) // Nếu selected là true, đổi màu nền thành màu vàng
            } else {
                holder.selected.setBackgroundResource(R.drawable.white_star_background) // Nếu selected là false, đổi màu nền về trắng
            }
        }

        return view
    }

    private class ViewHolder(view: View) {
        val avatar = view.findViewById<TextView>(R.id.avatar)
        val username = view.findViewById<TextView>(R.id.username)
        val message = view.findViewById<TextView>(R.id.message)
        val time = view.findViewById<TextView>(R.id.time)
        val selected = view.findViewById<ImageView>(R.id.selected)
    }
}