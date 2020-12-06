package com.dkn.subsatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail.view.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvObject: TextView = findViewById(R.id.tv_object_received)
        val tvPoto: ImageView = findViewById(R.id.poto)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        val poto = user.avatar
        tvPoto.setImageResource(poto)
        val text = "Name : ${user.name}\nCompany : ${user.company}\nLocation : ${user.location}\nRepository : ${user.repository}\nFollowers : ${user.followers}\nFollowing : ${user.following}"
        tvObject.text = text
    }
}