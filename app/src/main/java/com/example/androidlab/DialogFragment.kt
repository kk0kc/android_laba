package com.example.androidlab


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.androidlab.databinding.FragmentDialogBinding


open class DialogFragment : DialogFragment(R.layout.fragment_dialog) {
    private var _binding: FragmentDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = FragmentDialogBinding.inflate(LayoutInflater.from(context))
        val inflater = this.layoutInflater
        val view = inflater?.inflate(R.layout.fragment_dialog, null)
        val name = view.findViewById<EditText>(R.id.til_name)
        val author = view.findViewById<EditText>(R.id.til_author)
        var position = view.findViewById<EditText>(R.id.til_position)

        val dialog = AlertDialog.Builder(context)
        dialog.setView(view)
        dialog.setPositiveButton("OK") {
                    dialog, _ ->
                var positionNumb = if (position.text.toString().isNotBlank())
                    (position.text.toString().toInt()) else Repository.dataList.size
                Repository.addItem(positionNumb
                    ,MyItems.Song(positionNumb
                        ,name.text.toString()
                    ,author.text.toString(), "https://secure.gravatar.com/avatar/b16810316f7a5fede3cc83c6bcade4fb?s=915&d=mm&r=g",
                    "not added", null))
                ListFragment.adapter?.submitList(Repository.dataList)

                dialog.dismiss()
            }.setNeutralButton("ОТМЕНА") {
                    dialog, _ ->
                dialog.dismiss()
            }
        return dialog.create()
    }
}