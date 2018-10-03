package net.oldbigbuddha.sample.sample_recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set Toolbar
        setSupportActionBar(my_toolbar)
//        my_toolbar.inflateMenu(R.menu.menu_main)

        // Initialize RecyclerView
        recycler_items.layoutManager = LinearLayoutManager(this)

        // Initialize Adapter
        val adapter = ItemAdapter(ArrayList(), this)

        bt_add_item.setOnClickListener {
            if ( !TextUtils.isEmpty( et_item.text.toString() ) ) {

                val task = Item( mName = et_item.text.toString() )
                adapter.addItem(task)

            } else {

                Snackbar.make(container, "Task is empty", Snackbar.LENGTH_SHORT).show();

            }

            et_item.setText("")

        }

        recycler_items.adapter = adapter

    }
}
