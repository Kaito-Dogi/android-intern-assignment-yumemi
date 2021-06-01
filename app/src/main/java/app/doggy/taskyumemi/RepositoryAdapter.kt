package app.doggy.taskyumemi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RepositoryAdapter(val context: Context): RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    val items: MutableList<Repository> = mutableListOf()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.name_text_repository)
        val languageTextView: TextView = view.findViewById(R.id.language_text_repository)
        val updatedAtTextView: TextView = view.findViewById(R.id.updated_at_text_repository)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_cell, parent, false)
        return RepositoryAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.languageTextView.text = item.language

        val year = item.updatedAt.substring(0,4)
        var month = item.updatedAt.substring(5,7)
        val day = item.updatedAt.substring(8,10)

        when(month) {
            "01" -> month = "Jan"
            "02" -> month = "Feb"
            "03" -> month = "Mar"
            "04" -> month = "Apr"
            "05" -> month = "May"
            "06" -> month = "Jun"
            "07" -> month = "Jul"
            "08" -> month = "Aug"
            "09" -> month = "Sep"
            "10" -> month = "Oct"
            "11" -> month = "Nov"
            "12" -> month = "Dec"
        }

        holder.updatedAtTextView.text = "Updated on $day $month $year"

    }

    override fun getItemCount(): Int {
        return items.size
    }
}