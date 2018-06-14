package my.sample.kotlinviewmodel.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MyListModel : ViewModel() {

    private var listData: MutableLiveData<List<MyContent.Item>>? = null

    fun getListData(): LiveData<List<MyContent.Item>> {
        if (listData == null) {
            listData = MutableLiveData()
            loadListData()
        }
        return listData as MutableLiveData<List<MyContent.Item>>
    }

    private fun loadListData() {
        listData!!.value = MyContent.ITEMS
    }
}
