package com.example.dicodingsubmission1

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val users = ArrayList<User>()

    private lateinit var dataUserName: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataAvatar: TypedArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.supportActionBar?.title = "Github User"
        rv_list.setHasFixedSize(true)

        users.addAll(getAllUserData())

        rvList()
    }

    private fun getAllUserData(): ArrayList<User> {
        dataUserName = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)

        val user = ArrayList<User>()
        for (i in dataName.indices) {
            val listUser = User(
                dataUserName[i],
                dataName[i],
                dataLocation[i],
                dataRepository[i],
                dataCompany[i],
                dataFollowers[i],
                dataFollowing[i],
                dataAvatar.getResourceId(i, -1),
            )
            user.add(listUser)
        }
        return user
    }

    private fun rvList() {
        rv_list.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(users)
        rv_list.adapter = listUserAdapter
    }

}