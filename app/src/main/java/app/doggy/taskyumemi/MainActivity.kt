package app.doggy.taskyumemi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //ダミーデータを作成
    val contributors: List<Contributor> = listOf(
        Contributor("Kaito-Dogi","https://avatars.githubusercontent.com/u/49048577?v=4", 4, 2, "Doggy")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ContributorsAdapter(baseContext)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.adapter = adapter

        //Contributorsのリストを追加
        adapter.addAll(contributors)

    }
}