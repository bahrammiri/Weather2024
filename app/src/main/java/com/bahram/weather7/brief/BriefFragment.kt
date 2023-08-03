package com.bahram.weather7.brief

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bahram.weather7.SwipeToDeleteCallback
import com.bahram.weather7.adapter.BriefAdapter
import com.bahram.weather7.databinding.FragmentBriefBinding
import org.koin.android.ext.android.inject

class BriefFragment : Fragment() {

    //    lateinit var viewModel: BriefViewModel
    val viewModel: BriefViewModel by inject()
    private lateinit var binding: FragmentBriefBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentBriefBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onGetLayoutInflater(savedInstanceState: Bundle?): LayoutInflater {
//        val inflater = super.onGetLayoutInflater(savedInstanceState)
//        val contextThemeWrapper: Context = ContextThemeWrapper(requireContext(), R.style.Theme_Weather7)
//        return inflater.cloneInContext(contextThemeWrapper)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTextCityName.setOnEditorActionListener { v, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                val viewCurrent = requireActivity().currentFocus
                if (viewCurrent != null) {
                    val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(viewCurrent.windowToken, 0)
                    binding.editTextCityName.clearFocus()

                    if (binding.editTextCityName.text.toString() != "") {
                        val action = BriefFragmentDirections.actionBriefFragmentToPreviewFragment(binding.editTextCityName.text.toString())
                        binding.editTextCityName.setText("")
                        Navigation.findNavController(view).navigate(action)
                    }
                }

                true
            } else false

        }

//        val viewModel = get<BriefViewModel>()


//        viewModel = ViewModelProvider(requireActivity()).get(BriefViewModel::class.java)

        viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it == true) {
                binding.progressBarBrief.visibility = View.VISIBLE
                binding.recyclerViewBrief.visibility = View.GONE
            } else {
                binding.progressBarBrief.visibility = View.GONE
                binding.recyclerViewBrief.visibility = View.VISIBLE
            }

        }
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            if (it != "") {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()

            }
        }

        viewModel.citiesItems.observe(viewLifecycleOwner) {
            val briefAdapter = BriefAdapter(viewModel.citiesItems.value)
            binding.recyclerViewBrief.adapter = briefAdapter
            binding.recyclerViewBrief.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

            val swipeHandler = object : SwipeToDeleteCallback(requireContext()) {

                override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                    Log.i("rasoul", "${viewHolder.adapterPosition}")

                    viewModel.removeCityFromCitiesItems(viewHolder.adapterPosition, requireContext())
                    briefAdapter.notifyItemRemoved(viewHolder.adapterPosition)

                }
            }

            val itemTouchHelper = ItemTouchHelper(swipeHandler)
            itemTouchHelper.attachToRecyclerView(binding.recyclerViewBrief)

        }

        viewModel.start()

    }

    override fun onResume() {
        super.onResume()
        binding.editTextCityName.clearFocus()
    }

    val tyre14 = Tyre(14)
    val tyre16 = Tyre(16)
    val engine4 = Engine(4)
    val engine8 = Engine(8)


    //    val bmwX4 = Car(tyre16, engine8)
//    val peykan = Car(tyre14, engine4)
    val bmwX4 = BMWCar()
    val peykan = PeykanCar()

    fun bahram() {
        if (bmwX4.speed() > peykan.speed()) {
            Log.i("bb", "bmw")

        } else if (bmwX4.speed() < peykan.speed()) {
            Log.i("bb", "peykan")
        } else {
            Log.i("bb", "equal")
        }


    }


}


class BMWCar() {
    val tyre = Tyre(16)
    val engine = Engine(8)
    fun start() {}
    fun speed(): Int {
        var speed = tyre.size * engine.size

        return speed
    }

    fun stop() {}


}

class PeykanCar() {
    val tyre = Tyre(14)
    val engine = Engine(4)
    fun start() {}
    fun speed(): Int {
        var speed = tyre.size * engine.size

        return speed
    }

    fun stop() {}


}

//optimize

class Car(val tyre: Tyre, val engine: Engine) {
    fun start() {}
    fun speed(): Int {
        var speed = tyre.size * engine.size

        return speed
    }

    fun stop() {}

}

class Tyre(val size: Int) {
    fun tyreSize(): Int {
        return size
    }
}

class Engine(val size: Int) {

    fun cylinderSize(): Int {
        return size
    }
}

