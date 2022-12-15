package edu.virginia.cs4720.bucketlist.jss8ny

// Resources:
// https://johncodeos.com/how-to-use-room-in-android-using-kotlin/
// https://github.com/johncodeos-blog/RoomExample/
import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.text.*
import java.util.*

@SuppressLint("SimpleDateFormat")
class BucketListRVAdapter : ListAdapter<BucketListItem, BucketListRVAdapter.BucketListItemHolder>(DiffCallback()) {

    class BucketListItemHolder(view: View) : RecyclerView.ViewHolder(view)

    private lateinit var listener: RecyclerClickListener
    fun setItemListener(listener: RecyclerClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BucketListItemHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.bucket_list_item_row, parent, false)
        val bucketListItemHolder = BucketListItemHolder(v)

        // When click the "x", instantiate onItemRemoveClick()
        val bucketListItemDelete = bucketListItemHolder.itemView.findViewById<ImageView>(R.id.bucket_list_item_delete)
        bucketListItemDelete.setOnClickListener {
            listener.onItemRemoveClick(bucketListItemHolder.adapterPosition)
        }

        // When click on list item, instantiate onItemClick()
        val bucketListItem = bucketListItemHolder.itemView.findViewById<CardView>(R.id.bucket_list_item)
        bucketListItem.setOnClickListener {
            listener.onItemClick(bucketListItemHolder.adapterPosition)
        }

        // Reference:
        // https://www.android--code.com/2020/07/android-kotlin-checkbox-checked-change.html

        // When click on checkbox, instantiate onItemCheckboxClick() or onItemCheckboxUnclick() depending on state of checkbox
        val bucketListItemCheckbox = bucketListItemHolder.itemView.findViewById<CheckBox>(R.id.bucket_list_item_checkbox)
        bucketListItemCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                listener.onItemCheckboxClick(bucketListItemHolder.adapterPosition)
            }
            else{
                listener.onItemCheckboxUnclick(bucketListItemHolder.adapterPosition)
            }
        }

        return bucketListItemHolder
    }

    override fun onBindViewHolder(holder: BucketListItemHolder, position: Int) {
        val currentItem = getItem(position)

        // Display bucket list item text
        val bucketListItemText = holder.itemView.findViewById<TextView>(R.id.bucket_list_item_text)
        bucketListItemText.text = currentItem.itemText

        // Reference:
        // https://stackoverflow.com/questions/64187244/set-textview-visibility-based-on-button-click-in-kotlin
        // https://www.tutorialspoint.com/how-to-change-the-color-of-a-checkbox-in-android-using-kotlin

        // Change item display based on checked or not
        val bucketListItemComplete = holder.itemView.findViewById<CheckBox>(R.id.bucket_list_item_checkbox)
        val bucketListItemDueLine = holder.itemView.findViewById<LinearLayout>(R.id.bucket_list_item_due_line)
        val bucketListItemCompleteLine = holder.itemView.findViewById<LinearLayout>(R.id.bucket_list_item_complete_line)
        val bucketListItemCard = holder.itemView.findViewById<CardView>(R.id.bucket_list_item)
        bucketListItemComplete.isChecked = currentItem.complete
        if (bucketListItemComplete.isChecked) {
            // Display complete date on card if item complete
            bucketListItemDueLine.visibility = View.GONE
            bucketListItemCompleteLine.visibility = View.VISIBLE
            // Turn the color of the card green if completed
            bucketListItemCard.setBackgroundColor(Color.parseColor("#5BB1A9"))
        }
        else {
            // Display due date on card if item not complete
            bucketListItemDueLine.visibility = View.VISIBLE
            bucketListItemCompleteLine.visibility = View.GONE
            // Turn the color of the card blue if completed (and red if date is past today's date)
            if (currentItem.dueDate!! < Date().time) {
                bucketListItemCard.setBackgroundColor(Color.parseColor("#CF7272"))
            }
            else {
                bucketListItemCard.setBackgroundColor(Color.parseColor("#59B6FF"))
            }
        }

        // Set bucket list item due date
        val bucketListItemDueDate = holder.itemView.findViewById<TextView>(R.id.bucket_list_item_due_date)
        bucketListItemDueDate.text = SimpleDateFormat("EEE LLLL dd, yyyy").format(currentItem.dueDate)

        // Set bucket list item complete date
        val bucketListItemCompleteDate = holder.itemView.findViewById<TextView>(R.id.bucket_list_item_complete_date)
        bucketListItemCompleteDate.text = SimpleDateFormat("EEE LLLL dd, yyyy").format(currentItem.completeDate)

    }

    // Ensure items/contents are the same
    class DiffCallback : DiffUtil.ItemCallback<BucketListItem>() {
        override fun areItemsTheSame(oldItem: BucketListItem, newItem: BucketListItem) =
            oldItem.createDate == newItem.createDate

        override fun areContentsTheSame(oldItem: BucketListItem, newItem: BucketListItem) =
            oldItem == newItem
    }

}