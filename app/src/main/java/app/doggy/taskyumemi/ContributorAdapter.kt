package app.doggy.taskyumemi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load

class ContributorAdapter(private val context: Context): RecyclerView.Adapter<ContributorAdapter.ViewHolder>() {

    //リスト表示するデータの配列
    val items: MutableList<Contributor> = mutableListOf()

    //ViewHolderの定義
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val loginTextView: TextView = view.findViewById(R.id.login_text)
        val avatarImage: ImageView = view.findViewById(R.id.avator_image)
        val followersTextView: TextView = view.findViewById(R.id.followers_text)
        val followingTextView: TextView = view.findViewById(R.id.following_text)
        val nameTextView: TextView = view.findViewById(R.id.name_text)
    }

    //ViewHolderを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contributor_cell, parent, false)
        return ViewHolder(view)
    }

    //position番目のセルにデータを表示
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.loginTextView.text = item.login
        holder.avatarImage.load(item.imageUrl)
        holder.followersTextView.text = item.followers.toString()
        holder.followingTextView.text = item.following.toString()
        holder.nameTextView.text = item.name
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //引数にとったデータをリストに追加
    fun addAll(items: List<Contributor>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}