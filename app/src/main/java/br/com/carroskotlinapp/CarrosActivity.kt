package br.com.carroskotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import br.com.carroskotlinapp.adapter.CarrosAdapter
import br.com.carroskotlinapp.data.Mock
import br.com.carroskotlinapp.domain.Carro
import kotlinx.android.synthetic.main.activity_carros.*

class CarrosActivity : AppCompatActivity() {

    val carros = ArrayList<Carro>()

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(Carro.CARROS, carros)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)

        carros.addAll(
            savedInstanceState
                ?. getParcelableArrayList(Carro.CARROS)
                ?: Mock().gerarCarro(resources))
        initRecycler()
    }

    private fun initRecycler() {
        rv_carros.setHasFixedSize( true )

        val mLayoutManager = LinearLayoutManager( this )
        rv_carros.layoutManager = mLayoutManager

        val divider = DividerItemDecoration( this, mLayoutManager.orientation )
        rv_carros.addItemDecoration( divider )

        val adapter = CarrosAdapter( this, carros )
        rv_carros.adapter = adapter
    }
}
