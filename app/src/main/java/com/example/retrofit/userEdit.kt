package com.example.retrofit

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonObject
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response

class userEdit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_edit)
        val user =intent.getSerializableExtra("user") as User
        fill(user)
    }

    fun back(view: View?){
        finish();
    }

    fun fill(user: User){
        var name = findViewById<EditText>(R.id.edit_name)
        name.setText(user.name)

        var surname = findViewById<EditText>(R.id.edit_surname)
        surname.setText(user.surname)

        var age = findViewById<EditText>(R.id.edit_age)
        age.setText(user.age.toString())

        var about = findViewById<EditText>(R.id.edit_about)
        about.setText(user.about)

        var button = findViewById<Button>(R.id.save)

        button.setOnClickListener {
            saveUser(user.id, name.text.toString(),surname.text.toString(),age.text.toString(), about.text.toString(), user )
        }
    }

    fun saveUser(id:Int ,name: String, surname:String,age: String,about: String, user: User) {

        var body = JsonObject()
        body.addProperty("name",name)
        body.addProperty("surname",surname)
        body.addProperty("age",age)
        body.addProperty("about",about)


        Api.getClient().saveUser(id, body,
            (object : Callback<User> {
                override fun success(t: User?, response: Response?) {
                    //TODO("Not yet implemented")
                    back(null)
                }

                override fun failure(error: RetrofitError?) {
                    println(error)
                }

            })
        )
    }
}