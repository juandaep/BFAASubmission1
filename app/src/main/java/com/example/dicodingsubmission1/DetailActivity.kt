package com.example.dicodingsubmission1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        this.supportActionBar?.hide()

        val user = intent.getParcelableExtra(EXTRA_DATA) as? User
        tv_name.text = user?.name.toString()
        tv_userName.text = user?.username.toString()
        tv_location.text = user?.location.toString()
        _20.text = user?.repository.toString()
        tv_company.text = user?.company.toString()
        _10.text = user?.followers.toString()
        _15.text = user?.following.toString()

        Glide.with(this).load(user?.avatar).into(img_avatar)

        btn_send_email.setOnClickListener(this)
        btn_share.setOnClickListener(this)
        btn_follow.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_send_email -> {
                val email = "mailto:test@gmail.com"
                val intentEmail = Intent(Intent.ACTION_VIEW, Uri.parse(email))
                startActivity(intentEmail)
            }

            R.id.btn_share -> {
                    val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Share this profile: https//github.com")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }

            R.id.btn_follow -> Toast.makeText(this, "Followed", Toast.LENGTH_SHORT).show()

        }
    }


}