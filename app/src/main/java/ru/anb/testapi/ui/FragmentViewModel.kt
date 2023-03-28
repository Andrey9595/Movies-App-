package ru.anb.testapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.anb.testapi.models.Categories
import ru.anb.testapi.retrofit.ApiService
import ru.anb.testapi.retrofit.RetrofitClient

class FragmentViewModel: ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<Categories>?>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Categories>?> {
        return liveDataList
    }

    fun loodPost(){
        val retroInstance = RetrofitClient.getRetroInstance()
        val retroService = retroInstance.create(ApiService::class.java)
        val call = retroService.getCountryList()
        call.enqueue(object : Callback<List<Categories>> {
            override fun onResponse(
                call: Call<List<Categories>>,
                response: Response<List<Categories>>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Categories>>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }
}