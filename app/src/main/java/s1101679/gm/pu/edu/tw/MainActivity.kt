package s1101679.gm.pu.edu.tw

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var timeTextView: TextView
    private lateinit var activityTextView: TextView
    private lateinit var activityImageView: ImageView
    private lateinit var spinner: Spinner

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeTextView = findViewById(R.id.timeTextView)
        activityTextView = findViewById(R.id.activityTextView)
        activityImageView = findViewById(R.id.activityImageView)
        spinner = findViewById(R.id.spinner)

        updateCurrentTime()

        // 每秒更新時間
        object : CountDownTimer(Long.MAX_VALUE, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                updateCurrentTime()
            }

            override fun onFinish() {
                // 不需要執行任何操作
            }
        }.start()

        // 創建一個ArrayAdapter作為下拉式菜單的適配器
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.choices,
            android.R.layout.simple_spinner_item
        )

        // 設置下拉式菜單的樣式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // 將適配器設置給Spinner
        spinner.adapter = adapter

        // 設置選項選擇事件監聽器
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedOption = parent.getItemAtPosition(position).toString()
                handleSelectedOption(selectedOption)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 如果沒有選擇任何選項，不執行任何操作
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_mon -> {
                // 创建一个 Intent 对象，用于跳转到 NewActivity
                val intent = Intent(this, NewActivity::class.java)
                startActivity(intent)
                return true
            }
            // 其他菜单项的处理逻辑
            // ...
        }
        return super.onOptionsItemSelected(item)
    }

    private fun hideImageView() {
        activityImageView.visibility = View.GONE
    }

    private fun showImageView() {
        activityImageView.visibility = View.VISIBLE
    }

    private fun handleSelectedOption(selectedOption: String) {
        // 在這裡處理選擇的選項
        if (selectedOption.isEmpty()) {
            hideImageView()
            return
        }

        // 根據選擇的選項顯示相應的圖片
        // 根據選擇的選項跳轉至相應的頁面
        when (selectedOption) {
            "星期一" -> {
                val intent = Intent(this@MainActivity, ImageActivity1::class.java)
                startActivity(intent)
            }
            "星期二" -> {
                val intent = Intent(this@MainActivity, ImageActivity2::class.java)
                startActivity(intent)
            }
            "星期三" -> {
                val intent = Intent(this@MainActivity, ImageActivity3::class.java)
                startActivity(intent)
            }
            "星期四" -> {
                val intent = Intent(this@MainActivity, ImageActivity4::class.java)
                startActivity(intent)
            }
            "星期五" -> {
                val intent = Intent(this@MainActivity, ImageActivity5::class.java)
                startActivity(intent)
            }
        }
    }

    private fun updateCurrentTime() {
        val calendar: Calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = dateFormat.format(calendar.time)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)


        // 根據日期和時間顯示不同活動項目
        when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY -> {
                when {
                    currentTime >= "09:00" && currentTime < "10:00" -> {
                        activityImageView.setImageResource(R.drawable.breakfast)
                        activityTextView.text = "早餐時間&上廁所&裝水時間"
                    }
                    currentTime >= "10:00" && currentTime < "11:00" -> {
                        activityImageView.setImageResource(R.drawable.clay)
                        activityTextView.text = "陶土課程時間"
                    }
                    currentTime >= "11:00" && currentTime < "12:00" -> {
                        activityImageView.setImageResource(R.drawable.book)
                        activityTextView.text = "看書閱讀時間"
                    }
                    currentTime >= "12:00" && currentTime < "13:00" -> {
                        activityImageView.setImageResource(R.drawable.lunch)
                        activityTextView.text = "午餐時間&上廁所&裝水時間"
                    }
                    currentTime >= "13:00" && currentTime < "14:00" -> {
                        activityImageView.setImageResource(R.drawable.sleep)
                        activityTextView.text = "午休時間&上廁所&裝水時間"
                    }
                    currentTime >= "14:00" && currentTime < "15:00" -> {
                        activityImageView.setImageResource(R.drawable.sports)
                        activityTextView.text = "運動時間"
                    }
                    currentTime >= "15:00" && currentTime < "16:00" -> {
                        activityImageView.setImageResource(R.drawable.dessert)
                        activityTextView.text = "點心時間&上廁所&裝水時間"
                    }
                    currentTime >= "16:00" && currentTime < "17:00" -> {
                        activityImageView.setImageResource(R.drawable.free)
                        activityTextView.text = "自由活動時間"
                    }
                    else -> {
                        activityImageView.setImageResource(R.drawable.home)
                        activityTextView.text = "下課回家時間"
                    }
                }
            }
            Calendar.TUESDAY -> {
                when {
                    currentTime >= "09:00" && currentTime < "10:00" -> {
                        activityImageView.setImageResource(R.drawable.breakfast)
                        activityTextView.text = "早餐時間&上廁所&裝水時間"
                    }
                    currentTime >= "10:00" && currentTime < "12:00" -> {
                        activityImageView.setImageResource(R.drawable.cook)
                        activityTextView.text = "烹飪課時間"
                    }
                    currentTime >= "12:00" && currentTime < "13:00" -> {
                        activityImageView.setImageResource(R.drawable.lunch)
                        activityTextView.text = "午餐時間&上廁所&裝水時間"
                    }
                    currentTime >= "13:00" && currentTime < "14:00" -> {
                        activityImageView.setImageResource(R.drawable.sleep)
                        activityTextView.text = "午休時間&上廁所&裝水時間"
                    }
                    currentTime >= "14:00" && currentTime < "15:00" -> {
                        activityImageView.setImageResource(R.drawable.book)
                        activityTextView.text = "閱讀時間"
                    }
                    currentTime >= "15:00" && currentTime < "16:00" -> {
                        activityImageView.setImageResource(R.drawable.dessert)
                        activityTextView.text = "點心時間&上廁所&裝水時間"
                    }
                    currentTime >= "16:00" && currentTime < "17:00" -> {
                        activityImageView.setImageResource(R.drawable.free)
                        activityTextView.text = "自由活動時間"
                    }
                    else -> {
                        activityImageView.setImageResource(R.drawable.home)
                        activityTextView.text = "下課回家時間"
                    }
                }
            }
            Calendar.WEDNESDAY -> {
                when {
                    currentTime >= "09:00" && currentTime < "10:00" -> {
                        activityImageView.setImageResource(R.drawable.breakfast)
                        activityTextView.text = "早餐時間&上廁所&裝水時間"
                    }
                    currentTime >= "10:00" && currentTime < "12:00" -> {
                        activityImageView.setImageResource(R.drawable.swimming)
                        activityTextView.text = "游泳課時間"
                    }
                    currentTime >= "12:00" && currentTime < "13:00" -> {
                        activityImageView.setImageResource(R.drawable.lunch)
                        activityTextView.text = "午餐時間&上廁所&裝水時間"
                    }
                    currentTime >= "13:00" && currentTime < "14:00" -> {
                        activityImageView.setImageResource(R.drawable.sleep)
                        activityTextView.text = "午休時間&上廁所&裝水時間"
                    }
                    currentTime >= "14:00" && currentTime < "15:00" -> {
                        activityImageView.setImageResource(R.drawable.plant)
                        activityTextView.text = "植物栽培時間"
                    }
                    currentTime >= "15:00" && currentTime < "16:00" -> {
                        activityImageView.setImageResource(R.drawable.dessert)
                        activityTextView.text = "點心時間&上廁所&裝水時間"
                    }
                    currentTime >= "16:00" && currentTime < "17:00" -> {
                        activityImageView.setImageResource(R.drawable.free)
                        activityTextView.text = "自由活動時間"
                    }
                    else -> {
                        activityImageView.setImageResource(R.drawable.home)
                        activityTextView.text = "下課回家時間"
                    }
                }
            }
            Calendar.THURSDAY -> {
                when {
                    currentTime >= "09:00" && currentTime < "10:00" -> {
                        activityImageView.setImageResource(R.drawable.breakfast)
                        activityTextView.text = "早餐時間&上廁所&裝水時間"
                    }
                    currentTime >= "10:00" && currentTime < "11:00" -> {
                        activityImageView.setImageResource(R.drawable.music)
                        activityTextView.text = "音樂課時間"
                    }
                    currentTime >= "11:00" && currentTime < "12:00" -> {
                        activityImageView.setImageResource(R.drawable.sports)
                        activityTextView.text = "運動課時間"
                    }
                    currentTime >= "12:00" && currentTime < "13:00" -> {
                        activityImageView.setImageResource(R.drawable.lunch)
                        activityTextView.text = "午餐時間&上廁所&裝水時間"
                    }
                    currentTime >= "13:00" && currentTime < "14:00" -> {
                        activityImageView.setImageResource(R.drawable.sleep)
                        activityTextView.text = "午休時間&上廁所&裝水時間"
                    }
                    currentTime >= "14:00" && currentTime < "15:00" -> {
                        activityImageView.setImageResource(R.drawable.draw)
                        activityTextView.text = "畫畫時間"
                    }
                    currentTime >= "15:00" && currentTime < "16:00" -> {
                        activityImageView.setImageResource(R.drawable.dessert)
                        activityTextView.text = "點心時間&上廁所&裝水時間"
                    }
                    currentTime >= "16:00" && currentTime < "17:00" -> {
                        activityImageView.setImageResource(R.drawable.free)
                        activityTextView.text = "自由活動時間"
                    }
                    else -> {
                        activityImageView.setImageResource(R.drawable.home)
                        activityTextView.text = "下課回家時間"
                    }
                }
            }
            Calendar.FRIDAY -> {
                when {
                    currentTime >= "09:00" && currentTime < "10:00" -> {
                        activityImageView.setImageResource(R.drawable.breakfast)
                        activityTextView.text = "早餐時間&上廁所&裝水時間"
                    }
                    currentTime >= "10:00" && currentTime < "12:00" -> {
                        activityImageView.setImageResource(R.drawable.movie)
                        activityTextView.text = "電影課時間"
                    }
                    currentTime >= "12:00" && currentTime < "13:00" -> {
                        activityImageView.setImageResource(R.drawable.lunch)
                        activityTextView.text = "午餐時間&上廁所&裝水時間"
                    }
                    currentTime >= "13:00" && currentTime < "14:00" -> {
                        activityImageView.setImageResource(R.drawable.sleep)
                        activityTextView.text = "午休時間&上廁所&裝水時間"
                    }
                    currentTime >= "14:00" && currentTime < "15:00" -> {
                        activityImageView.setImageResource(R.drawable.cook)
                        activityTextView.text = "家政課時間"
                    }
                    currentTime >= "15:00" && currentTime < "16:00" -> {
                        activityImageView.setImageResource(R.drawable.dessert)
                        activityTextView.text = "點心時間&上廁所&裝水時間"
                    }
                    currentTime >= "16:00" && currentTime < "17:00" -> {
                        activityImageView.setImageResource(R.drawable.free)
                        activityTextView.text = "自由活動時間"
                    }
                    else -> {
                        activityImageView.setImageResource(R.drawable.home)
                        activityTextView.text = "下課回家時間"
                    }
                }
            }
            else -> {
                activityImageView.setImageResource(R.drawable.home)
                activityTextView.text = "下課回家時間"
            }
        }

        timeTextView.text = "當前時間：$currentTime"
    }
}