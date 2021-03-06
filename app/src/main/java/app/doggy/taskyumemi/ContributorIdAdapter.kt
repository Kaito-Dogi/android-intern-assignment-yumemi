package app.doggy.taskyumemi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load

class ContributorIdAdapter(
    private val context: Context,
    private var listener: OnItemClickListener
    ) : RecyclerView.Adapter<ContributorIdAdapter.ViewHolder>() {

    //リスト表示するデータの配列
    private val items: MutableList<ContributorId> = mutableListOf()

    //ViewHolderの定義
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val loginTextView: TextView = view.findViewById(R.id.login_text)
        val avatarImage: ImageView = view.findViewById(R.id.avator_image)
        val nameTextView: TextView = view.findViewById(R.id.name_text)
        val container: LinearLayout = view.findViewById(R.id.container)
    }

    //ViewHolderを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contributor_cell, parent, false)
        return ViewHolder(view)
    }

    //position番目のセルにデータを表示
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.login
        //holder.loginTextView.text = item.login
        holder.avatarImage.load(item.imageUrl)

        holder.container.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //引数にとったデータをリストに追加
    fun addAll(items: MutableList<ContributorId>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(item: ContributorId)
    }
}