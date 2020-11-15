package com.example.retrofit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
       getUsers(null)
    }

     fun getUsers(view: View?) {
        Api.getClient().getUsers(
            (object : Callback<List<User>> {
                override fun success(t: List<User>, response: Response?) {
                    //TODO("Not yet implemented")
                    showUsers(t);
                }

                override fun failure(error: RetrofitError?) {
                    TODO("Not yet implemented")
                }

            })
        )
    }

    fun showUsers(users: List<User>){

        var container = findViewById<LinearLayout>(R.id.users_list)
        container.removeAllViews()


        users.forEach{
            var text = TextView(this);
            var string = it.name+ " "+it.surname +"\nage:"+it.age+"\n"+it.about;
            text.text = string
            text.height = 100
            text.setPadding(10,10,10,10)
            var user = it
            text.setOnClickListener{
               val intent = Intent(this, userEdit::class.java);
                intent.putExtra("user", user)
                startActivity(intent);
            }
            container.addView(text);
        }
    }
}