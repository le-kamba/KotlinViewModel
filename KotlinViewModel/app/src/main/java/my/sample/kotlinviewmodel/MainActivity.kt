package my.sample.kotlinviewmodel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import my.sample.kotlinviewmodel.fragment.MyListFragment
import my.sample.kotlinviewmodel.model.MyContent

class MainActivity : AppCompatActivity() , MyListFragment.OnListFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onListFragmentInteraction(item: MyContent.Item?) {
        Log.d("KotlinViewModel", "onListFragmentInteraction")

        val builder = AlertDialog.Builder(this)
        builder.setMessage(item.toString()).setTitle("選択")
                .setPositiveButton(android.R.string.ok, null)
        builder.show()
    }
}
