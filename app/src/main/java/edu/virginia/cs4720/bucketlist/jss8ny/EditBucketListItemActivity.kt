package edu.virginia.cs4720.bucketlist.jss8ny

// Resources:
// https://johncodeos.com/how-to-use-room-in-android-using-kotlin/
// https://github.com/johncodeos-blog/RoomExample/
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator
import java.text.SimpleDateFormat
import java.time.*
import java.util.*

@SuppressLint("RestrictedApi")
class EditBucketListItemActivity : AppCompatActivity(){

    private lateinit var editBucketListItemBackground: RelativeLayout
    private lateinit var editBucketListItemWindowBg: LinearLayout
    private lateinit var editBucketListItemBackArrow: ImageView

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_bucket_list_item)

        editBucketListItemBackground = findViewById(R.id.edit_bucket_list_item_background)
        editBucketListItemWindowBg = findViewById(R.id.edit_bucket_list_item_window_bg)
        editBucketListItemBackArrow = findViewById(R.id.edit_bucket_list_item_back)

        setActivityStyle()

        // Get the current values of bucket list item
        val bucketListItemCreateDate = intent.getLongExtra("bucket_list_item_create_date",0)
        val bucketListItemTextToEdit = intent.getStringExtra("bucket_list_item_text")
        val bucketListItemDateToEdit = intent.getLongExtra("bucket_list_item_due_date",0)
        val bucketListItemComplete = intent.getBooleanExtra("bucket_list_item_complete",false)
        val bucketListItemCompleteDate = intent.getLongExtra("bucket_list_item_complete_date",0)

        // Reference:
        // https://stackoverflow.com/questions/31679865/edittext-with-word-wrap-without-line-breaks-and-with-keyboard-action-set-to-n
        val editBucketListItemText = findViewById<TextView>(R.id.edit_bucket_list_item_text)
        // Have text wrap around the textbox
        editBucketListItemText.maxLines = Integer.MAX_VALUE
        editBucketListItemText.setHorizontallyScrolling(false)
        // Populate textbox with previous text
        editBucketListItemText.text = bucketListItemTextToEdit ?: ""

        // Reference
        // https://stackoverflow.com/questions/45842167/how-to-use-datepickerdialog-in-kotlin
        // https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html

        // Set date picker to current due date
        val datePickerDate = findViewById<DatePicker>(R.id.edit_bucket_list_item_due_date)
        val bucketListItemDueDate = Calendar.getInstance()
        bucketListItemDueDate.time = Date(bucketListItemDateToEdit)
        val year = bucketListItemDueDate.get(Calendar.YEAR)
        val month = bucketListItemDueDate.get(Calendar.MONTH)
        val day = bucketListItemDueDate.get(Calendar.DAY_OF_MONTH)
        datePickerDate.updateDate(year, month, day)

        // Set complete date display depending on if item is complete or not
        val editBucketListItemCompleteStatus = findViewById<TextView>(R.id.edit_bucket_list_item_complete_status)
        if (bucketListItemComplete) {
            editBucketListItemCompleteStatus.text = SimpleDateFormat("LLLL dd, yyyy").format(bucketListItemCompleteDate)
        }
        else {
            editBucketListItemCompleteStatus.text = "Item has not been completed yet."
        }

        // Return bucket list item to MainActivity on button click
        val addBucketListItemButton = findViewById<Button>(R.id.edit_bucket_list_item_button)
        addBucketListItemButton.setOnClickListener {
            // Set due date to what is selected on the date picker
            bucketListItemDueDate.set(Calendar.YEAR, datePickerDate.year)
            bucketListItemDueDate.set(Calendar.MONTH, datePickerDate.month)
            bucketListItemDueDate.set(Calendar.DAY_OF_MONTH, datePickerDate.dayOfMonth)
            bucketListItemDueDate.set(Calendar.HOUR_OF_DAY, 23)
            bucketListItemDueDate.set(Calendar.MINUTE, 59)
            bucketListItemDueDate.set(Calendar.SECOND, 59)
            // Set item attributes
            val data = Intent()
            data.putExtra("bucket_list_item_create_date", bucketListItemCreateDate)
            data.putExtra("bucket_list_item_text", editBucketListItemText.text.toString())
            data.putExtra("bucket_list_item_due_date", bucketListItemDueDate.timeInMillis)
            data.putExtra("bucket_list_item_complete", bucketListItemComplete)
            data.putExtra("bucket_list_item_complete_date", bucketListItemCompleteDate)
            setResult(RESULT_OK, data)
            // Close current window
            onBackPressed()
        }
    }

    private fun setActivityStyle() {
        // Make the background full screen, over status bar
//        window.decorView.systemUiVisibility =
//            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//        this.window.statusBarColor = Color.TRANSPARENT
//        val winParams = this.window.attributes
//        winParams.flags =
//            winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS.inv()
//        this.window.attributes = winParams

        // Fade animation for the background of Popup Window
        val alpha = 100 //between 0-255
        val alphaColor = ColorUtils.setAlphaComponent(Color.parseColor("#000000"), alpha)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), Color.TRANSPARENT, alphaColor)
        colorAnimation.duration = 500 // milliseconds
        colorAnimation.addUpdateListener { animator ->
            editBucketListItemBackground.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()

        editBucketListItemWindowBg.alpha = 0f
        editBucketListItemWindowBg.animate().alpha(1f).setDuration(500)
            .setInterpolator(DecelerateInterpolator()).start()

        // Close window when you tap on the dim background or back arrow
        editBucketListItemBackground.setOnClickListener { onBackPressed() }
        editBucketListItemBackArrow.setOnClickListener { onBackPressed() }
        // Prevent activity from closing when you tap on the pop-up's window background
        editBucketListItemWindowBg.setOnClickListener { }
    }

    override fun onBackPressed() {
        // Fade animation for the background of Popup Window when you press the back button
        val alpha = 100 // between 0-255
        val alphaColor = ColorUtils.setAlphaComponent(Color.parseColor("#000000"), alpha)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), alphaColor, Color.TRANSPARENT)
        colorAnimation.duration = 500 // milliseconds
        colorAnimation.addUpdateListener { animator ->
            editBucketListItemBackground.setBackgroundColor(
                animator.animatedValue as Int
            )
        }

        // Fade animation for the Popup Window when you press the back button
        editBucketListItemWindowBg.animate().alpha(0f).setDuration(500).setInterpolator(
            DecelerateInterpolator()
        ).start()

        // After animation finish, close the Activity
        colorAnimation.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                finish()
                overridePendingTransition(0, 0)
            }
        })
        colorAnimation.start()
    }

}