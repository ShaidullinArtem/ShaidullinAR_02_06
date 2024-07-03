package com.example.shaidullinar_02_06

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter(context: Context, private val userList: List<UserType>) : ArrayAdapter<UserType>(context, 0, userList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = inflater.inflate(R.layout.user_list_item, parent, false)

        // Получаем элементы из макета
        val imageView = rowView.findViewById<ImageView>(R.id.user_image)
        val userNameText = rowView.findViewById<TextView>(R.id.user_name)
        val userStatusText = rowView.findViewById<TextView>(R.id.user_status)
        val userMessagesCount = rowView.findViewById<TextView>(R.id.user_messages)

        // Устанавливаем данные для каждого элемента
        val user = getItem(position)!!
        imageView.setImageResource(R.drawable.user1)
        userNameText.text = user.name
        userStatusText.text = user.status
        if (user.messageCount > 0) {
            userMessagesCount.text = user.messageCount.toString()
        } else {
            userMessagesCount.visibility = View.INVISIBLE
        }

        return rowView
    }
}
