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
import android.util.*
import java.text.SimpleDateFormat
import java.util.*
import java.time.*

@SuppressLint("RestrictedApi")
class AddBucketListItemActivity : AppCompatActivity(){

    private lateinit var addBucketListItemBackground: RelativeLayout
    private lateinit var addBucketListItemWindowBg: LinearLayout
    private lateinit var addBucketListItemBackArrow: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bucket_list_item)

        addBucketListItemBackground = findViewById(R.id.add_bucket_list_item_background)
        addBucketListItemWindowBg = findViewById(R.id.add_bucket_list_item_window_bg)
        addBucketListItemBackArrow = findViewById(R.id.add_bucket_list_item_back)

        setActivityStyle()

        // Get the current text and due date of bucket list item
        val bucketListItemCreateDate = intent.getLongExtra("bucket_list_item_create_date",0)
        val bucketListItemText = intent.getStringExtra("bucket_list_item_text")
        val bucketListItemDefaultDueDate = intent.getLongExtra("bucket_list_item_due_date",Date().time)
        val bucketListItemComplete = intent.getBooleanExtra("bucket_list_item_complete",false)
        val bucketListItemCompleteDate = intent.getLongExtra("bucket_list_item_complete_date",0)


        // Reference:
        // https://stackoverflow.com/questions/31679865/edittext-with-word-wrap-without-line-breaks-and-with-keyboard-action-set-to-n
        val addBucketListItemText = findViewById<TextView>(R.id.add_bucket_list_item_text)
        // Have text wrap around the textbox
        addBucketListItemText.maxLines = Integer.MAX_VALUE
        addBucketListItemText.setHorizontallyScrolling(false)
        // Populate textbox with previous text
        addBucketListItemText.text = bucketListItemText ?: ""

        // Reference
        // https://stackoverflow.com/questions/45842167/how-to-use-datepickerdialog-in-kotlin
        // // https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
        val datePickerDate = findViewById<DatePicker>(R.id.add_bucket_list_item_due_date)
//        datePickerDate.minDate = Date().time

        // Initialize calendar to today
        val bucketListItemDueDate = Calendar.getInstance()
        bucketListItemDueDate.time = Date(bucketListItemDefaultDueDate)

        // Return bucket list item to MainActivity on button click
        val addBucketListItemButton = findViewById<Button>(R.id.add_bucket_list_item_button)
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
            data.putExtra("bucket_list_item_text", addBucketListItemText.text.toString())
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
            addBucketListItemBackground.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()

        addBucketListItemWindowBg.alpha = 0f
        addBucketListItemWindowBg.animate().alpha(1f).setDuration(500)
            .setInterpolator(DecelerateInterpolator()).start()

        // Close window when you tap on the dim background or back arrow
        addBucketListItemBackground.setOnClickListener { onBackPressed() }
        addBucketListItemBackArrow.setOnClickListener { onBackPressed() }
        // Prevent activity from closing when you tap on the pop-up's window background
        addBucketListItemWindowBg.setOnClickListener { }
    }

    override fun onBackPressed() {
        // Fade animation for the background of Popup Window when you press the back button
        val alpha = 100 // between 0-255
        val alphaColor = ColorUtils.setAlphaComponent(Color.parseColor("#000000"), alpha)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), alphaColor, Color.TRANSPARENT)
        colorAnimation.duration = 500 // milliseconds
        colorAnimation.addUpdateListener { animator ->
            addBucketListItemBackground.setBackgroundColor(
                animator.animatedValue as Int
            )
        }

        // Fade animation for the Popup Window when you press the back button
        addBucketListItemWindowBg.animate().alpha(0f).setDuration(500).setInterpolator(
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