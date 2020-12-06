package com.dkn.subsatu

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedUser: User = users[position]
            val moveIntent = Intent(this, DetailActivity::class.java)
            moveIntent.putExtra(DetailActivity.EXTRA_USER, selectedUser)
            startActivity(moveIntent)
        }

    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)

    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                dataPhoto.getResourceId(position, -1),
                dataUsername[position],
                dataName[position],
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollowers[position],
                dataFollowing[position]
            )
            users.add(user)
        }
        adapter.users = users
    }

}

