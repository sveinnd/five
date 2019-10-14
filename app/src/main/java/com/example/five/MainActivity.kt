package com.example.five

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listdata.layoutManager = LinearLayoutManager(this)
        listdata.setHasFixedSize(true)
        val data = createPhoneData()
        listdata.adapter = PhoneAdapter(data, {phoneItem: Phone -> phoneItem(phoneItem)})
    }

    private fun phoneItem(phone: Phone){
        val showDetail = Intent(this, PhoneDetail::class.java)
        showDetail.putExtra(Intent.EXTRA_TEXT, phone.phone.toString())
        startActivity(showDetail)
    }

    private fun createPhoneData() : List<Phone>{
        val listdata = ArrayList<Phone>()
        listdata.add(Phone(6223471413, "Sveinnd"))
        listdata.add(Phone(6223478923, "Jeanne"))
        listdata.add(Phone(6223123933, "Strygwr"))
        return listdata
    }
}