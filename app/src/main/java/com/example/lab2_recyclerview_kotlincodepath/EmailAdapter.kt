package com.example.lab2_recyclerview_kotlincodepath

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvSender: TextView
        val tvTitle: TextView
        val tvSummary: TextView
        // as you render a row.

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            tvSender = itemView.findViewById(R.id.senderTv)
            tvTitle = itemView.findViewById(R.id.titleTv)
            tvSummary = itemView.findViewById(R.id.summaryTv)
            // the public final member variables created above

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.email_item,parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails.get(position)
        holder.tvSender.text = email.sender
        holder.tvTitle.text = email.title
        holder.tvSummary.text = email.summary
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}