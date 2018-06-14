package my.sample.kotlinviewmodel.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list.view.*
import my.sample.kotlinviewmodel.R
import my.sample.kotlinviewmodel.model.MyContent
import my.sample.kotlinviewmodel.model.MyListModel

class MyListFragment : Fragment() {

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var listModel: MyListModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Set the adapter
        if (view.list is RecyclerView) {
            view.list.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))

            with(view.list, {
                layoutManager = LinearLayoutManager(context)

                listModel = ViewModelProviders.of(activity!!).get(MyListModel::class.java)
                listModel.getListData().observe(activity!!, Observer { data ->
                    if(data==null){
                        // show empty view
                        view.emptyView.visibility = View.VISIBLE
                        visibility = View.INVISIBLE
                    }else {
                        view.emptyView.visibility = View.INVISIBLE
                        visibility = View.VISIBLE
                        adapter = ItemRecyclerViewAdapter(data, listener)
                    }
                })
            })
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * Listの行選択コールバック用リスナ
     */
    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: MyContent.Item?)
    }
}