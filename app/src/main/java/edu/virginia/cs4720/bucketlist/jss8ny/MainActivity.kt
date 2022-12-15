package edu.virginia.cs4720.bucketlist.jss8ny

// Resources:
// https://johncodeos.com/how-to-use-room-in-android-using-kotlin/
// https://github.com/johncodeos-blog/RoomExample/
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: BucketListRVAdapter

    private val bucketListDatabase by lazy { BucketListDatabase.getDatabase(this).bucketListDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()

        observeBucketList()

    }

    private fun setRecyclerView() {
        val bucketListRecyclerview = findViewById<RecyclerView>(R.id.bucket_list_recyclerview)
        bucketListRecyclerview.layoutManager = LinearLayoutManager(this)
        bucketListRecyclerview.setHasFixedSize(true)
        adapter = BucketListRVAdapter()
        adapter.setItemListener(object : RecyclerClickListener {

            // Tap the "x" to delete the list item
            override fun onItemRemoveClick(position: Int) {
                val bucketListList = adapter.currentList.toMutableList()
                val bucketListItemCreateDate = bucketListList[position].createDate
                val bucketListItemText = bucketListList[position].itemText
                val bucketListItemDueDate = bucketListList[position].dueDate
                val bucketListItemComplete = bucketListList[position].complete
                val bucketListItemCompleteDate = bucketListList[position].completeDate
                val removeBucketListItem = BucketListItem(bucketListItemCreateDate, bucketListItemText, bucketListItemDueDate, bucketListItemComplete, bucketListItemCompleteDate)
                lifecycleScope.launch {
                    bucketListDatabase.deleteBucketListItem(removeBucketListItem)
                }
            }

            // Tap the bucket list item to edit
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, EditBucketListItemActivity::class.java)
                val bucketListList = adapter.currentList.toMutableList()
                intent.putExtra("bucket_list_item_create_date", bucketListList[position].createDate)
                intent.putExtra("bucket_list_item_text", bucketListList[position].itemText)
                intent.putExtra("bucket_list_item_due_date", bucketListList[position].dueDate)
                intent.putExtra("bucket_list_item_complete", bucketListList[position].complete)
                intent.putExtra("bucket_list_item_complete_date", bucketListList[position].completeDate)
                editBucketListResultLauncher.launch(intent)
            }

            // Tap the checkbox to complete the list item
            override fun onItemCheckboxClick(position: Int) {
                val bucketListList = adapter.currentList.toMutableList()
                val bucketListItemCreateDate = bucketListList[position].createDate
                val bucketListItemText = bucketListList[position].itemText
                val bucketListItemDueDate = bucketListList[position].dueDate
                val bucketListItemComplete = true
                val bucketListItemCompleteDate = (
                    if (bucketListList[position].completeDate == 0.toLong()) {
                            Date().time
                        } else {
                            bucketListList[position].completeDate
                        })
                val editedBucketListItem = BucketListItem(bucketListItemCreateDate, bucketListItemText, bucketListItemDueDate, bucketListItemComplete, bucketListItemCompleteDate)
                lifecycleScope.launch {
                    bucketListDatabase.updateBucketListItem(editedBucketListItem)
                }
            }
            // Uncheck the checkbox to uncomplete the list item
            override fun onItemCheckboxUnclick(position: Int) {
                val bucketListList = adapter.currentList.toMutableList()
                val bucketListItemCreateDate = bucketListList[position].createDate
                val bucketListItemText = bucketListList[position].itemText
                val bucketListItemDueDate = bucketListList[position].dueDate
                val bucketListItemComplete = false
                val bucketListItemCompleteDate = 0.toLong()
                val editedBucketListItem = BucketListItem(bucketListItemCreateDate, bucketListItemText, bucketListItemDueDate, bucketListItemComplete, bucketListItemCompleteDate)
                lifecycleScope.launch {
                    bucketListDatabase.updateBucketListItem(editedBucketListItem)
                }
            }
        })
        bucketListRecyclerview.adapter = adapter
    }

    // Display bucket list list
    private fun observeBucketList() {
        lifecycleScope.launch {
            bucketListDatabase.getBucketList().collect { bucketListList ->
                adapter.submitList(bucketListList)
            }
        }
    }

    // Launcher for new bucket list item
    private val newBucketListItemResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Get the new note from the AddNoteActivity
                val bucketListItemCreateDate = Date().time
                val bucketListItemText = result.data?.getStringExtra("bucket_list_item_text")
                val bucketListItemDueDate = result.data?.getLongExtra("bucket_list_item_due_date",0)
                val bucketListItemComplete = result.data?.getBooleanExtra("bucket_list_item_text",false)
                val bucketListItemCompleteDate = result.data?.getLongExtra("bucket_list_item_due_date",0)
                // Add the new note at the top of the list
                val newBucketListItem = BucketListItem(bucketListItemCreateDate, bucketListItemText ?: "", bucketListItemDueDate, bucketListItemComplete==true, bucketListItemCompleteDate)
                lifecycleScope.launch {
                    bucketListDatabase.addBucketListItem(newBucketListItem)
                }
            }
        }

    // Launcher for edit bucket list item
    val editBucketListResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Get the edited note from the AddNoteActivity
                val bucketListItemCreateDate = result.data?.getLongExtra("bucket_list_item_create_date",0)
                val bucketListItemText = result.data?.getStringExtra("bucket_list_item_text")
                val bucketListItemDueDate = result.data?.getLongExtra("bucket_list_item_due_date",0)
                val bucketListItemComplete = result.data?.getBooleanExtra("bucket_list_item_complete",false)
                val bucketListItemCompleteDate = result.data?.getLongExtra("bucket_list_item_complete_date",0)
                // Update the note in the list
                val editedBucketListItem = BucketListItem(bucketListItemCreateDate,bucketListItemText ?: "", bucketListItemDueDate, bucketListItemComplete==true, bucketListItemCompleteDate)
                lifecycleScope.launch {
                    bucketListDatabase.updateBucketListItem(editedBucketListItem)
                }
            }
        }

    // The '+' menu button
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.add_bucket_list_item_menu_item) {
            // Open AddBucketListItemActivity
            val intent = Intent(this, AddBucketListItemActivity::class.java)
            newBucketListItemResultLauncher.launch(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bucket_list, menu)
        return true
    }

}