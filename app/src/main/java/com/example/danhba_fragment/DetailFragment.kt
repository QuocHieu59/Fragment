package com.example.danhba_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
val items_Phone: Array<String> = arrayOf("123456789", "098763152", "987632154", "741852963", "147258369")
val items_email: Array<String> = arrayOf("HUST@gmail.com", "CTSV@gmail.com", "LeBaVui@gmail.com", "Tuto@gmail.com", "support@gmail.com")
class DetailFragment : Fragment() {

    lateinit var textDetail: TextView
    lateinit var textPhone: TextView
    lateinit var textEmail: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textDetail = view.findViewById(R.id.text_detail)
        textPhone = view.findViewById(R.id.text_phone)
        textEmail = view.findViewById(R.id.text_email)

        val index = arguments?.getInt("INDEX", -1) ?: -1 // Nhận index từ bundle

        if (index != -1) {
            UpdateContent(index)
        }
    }

    fun UpdateContent(index: Int) {

        textDetail.text = items_name[index]
        textPhone.text = items_Phone[index]
        textEmail.text = items_email[index]
    }
}