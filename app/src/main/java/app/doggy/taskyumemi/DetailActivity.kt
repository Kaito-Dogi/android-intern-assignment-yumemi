package app.doggy.taskyumemi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import coil.api.load
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class DetailActivity : AppCompatActivity() {

    lateinit var loginText: TextView
    lateinit var avatarImage: ImageView
    lateinit var followersText: TextView
    lateinit var followingText: TextView
    lateinit var nameText: TextView
    lateinit var companyText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loginText = findViewById(R.id.login_text_detail)
        avatarImage = findViewById(R.id.avatar_image_detail)
        followersText = findViewById(R.id.followers_text_detail)
        followingText = findViewById(R.id.following_text_detail)
        nameText = findViewById(R.id.name_text_detail)
        companyText = findViewById(R.id.company_text_detail)

        //一覧画面からusernameを受け取る
        val login = intent.getStringExtra("login")

        val gson: Gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val contributorService = retrofit.create(ContributorService::class.java)

        //contributorの情報を表示
        runBlocking(Dispatchers.IO) {
            runCatching {
                contributorService.getContributor(login as String)
            }
        }.onSuccess {
            loginText.text = it.login
            avatarImage.load(it.imageUrl)
            followersText.text = it.followers.toString()
            followingText.text = it.following.toString()
            nameText.text = it.name
            companyText.text = it.company
        }.onFailure {
            Toast.makeText(baseContext, "情報の取得に失敗", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}