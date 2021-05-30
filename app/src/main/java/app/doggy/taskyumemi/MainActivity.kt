package app.doggy.taskyumemi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var contributorService: ContributorService
    lateinit var adapter: ContributorIdAdapter

    //val contributors: MutableList<Contributor> = mutableListOf()
    val contributorIds: MutableList<ContributorId> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson: Gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        contributorService = retrofit.create(ContributorService::class.java)

        adapter = ContributorIdAdapter(baseContext, object: ContributorIdAdapter.OnItemClickListener {
            override fun onItemClick(item: ContributorId) {
                //クリック時の処理
                val detailIntent = Intent(baseContext, DetailActivity::class.java)
                detailIntent.putExtra("login", item.login)
                startActivity(detailIntent)
            }
        })

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.adapter = adapter

        //ダミーデータを作成
        //contributorIds.add(ContributorId("Kaito-Dogi","https://avatars.githubusercontent.com/u/49048577?v=4"))

        runBlocking(Dispatchers.IO) {
            runCatching {
                contributorService.getContributorId()
            }
        }.onSuccess {
            for (id in it) {
                contributorIds.add(id)
            }
        }.onFailure {
            Toast.makeText(baseContext, "idの取得に失敗", Toast.LENGTH_SHORT).show()
        }

//        runBlocking(Dispatchers.IO) {
//            runCatching {
//                contributorService.getContributor(contributorIds[1])
//            }
//        }.onSuccess {
//            contributors.add(it)
//        }.onFailure {
//            Toast.makeText(baseContext, "contributorsの詳細情報の取得に失敗", Toast.LENGTH_SHORT).show()
//        }

        //Contributorsのリストを追加
        adapter.addAll(contributorIds)

        //Contributorsのリストを
        contributorIds.clear()
    }

}