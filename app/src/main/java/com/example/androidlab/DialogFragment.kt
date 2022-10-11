package com.example.androidlab



import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import com.example.androidlab.databinding.FragmentDialogBinding


open class ADialogFragment : DialogFragment(R.layout.fragment_dialog) {
    private var _binding: FragmentDialogBinding? = null
    private val binding get() = _binding!!
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = FragmentDialogBinding.inflate(LayoutInflater.from(context))



        return AlertDialog.Builder(requireContext())
                .setView(binding.root)
                .setPositiveButton("ПРИБАВИТЬ") {
                        dialog, _ ->
                    if(binding.textEdit.text.toString().toInt() !in 0..100){
                        binding.inputLayout.setError("Неверный формат данных")
                    }
                    else{
                    positiveAction()}
                }
                .setNegativeButton("ОТМЕНА") {
                        dialog, _ ->
                    if(binding.textEdit.text.toString().toInt() !in 0..100){
                        binding.inputLayout.setError("Неверный формат данных")
                    }
                    else{dialog.dismiss()}
                }
                .setNeutralButton("ВЫЧЕСТЬ") {
                        dialog, _ ->
                    neutralAction()
                }.create()


    }


    fun positiveAction() {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.container, FirstFragment.newInstance(
                        arguments?.getInt("counter_dia")!! +
                                binding.textEdit.text.toString().toInt()
                    )
                )
                .commit()
    }

    fun neutralAction() {
        if (binding.textEdit.text.toString().toInt()
            > arguments?.getInt("counter_dia")!!){
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.container, FirstFragment.newInstance(
                        arguments?.getInt("counter_dia")!!))
                .commit()
        } else {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.container, FirstFragment.newInstance(
                        arguments?.getInt("counter_dia")!! -
                                binding.textEdit.text.toString().toInt()
                    )
                )
                .commit()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object{
        fun newInstance(counter : Int) : ADialogFragment {
            val fragment = ADialogFragment()
            val bundle = Bundle()
            bundle.putInt("counter_dia", counter)
            fragment.arguments = bundle
            return fragment
        }
    }
}