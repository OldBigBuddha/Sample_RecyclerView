package net.oldbigbuddha.sample.sample_recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item.view.*

class ItemAdapter(
        private val mItems:   ArrayList<Item>,
        private val mContext: Context
): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    override fun getItemCount(): Int = mItems.size

    fun addItem(item: Item) {
        mItems.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false))

    private fun removeItem(position: Int) {
        mItems.removeAt(position - 1)
        notifyItemRemoved(position - 1)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvName.text      = mItems[position].mName

        // reference: Y.A.M の 雑記帳: SimpleDateFormat ではなく android.text.format.DateFormat を使おう - http://bit.ly/2OybKLu
        holder.tvCreatedAt.text = DateFormat.format("yyyy/MM/dd kk:mm:ss", mItems[position].mCreatedAt).toString()

        holder.btRemoveItem.setOnClickListener {
            removeItem(position)
        }

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvName:       TextView    = view.tv_name
        val tvCreatedAt:  TextView    = view.tv_created_at
        val btRemoveItem: ImageButton = view.bt_remove_item
    }
}