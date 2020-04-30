package com.example.optionsmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.remove
import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*

class MainActivity : AppCompatActivity() {

    val models : ArrayList<User> = arrayListOf()

    val adapter : ListAdapter= ListAdapter (this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerView.scrollToPosition(models.size-1)

        data()
    }

    fun data (){

        var model =User()

        model.title="1"
        model.description="Description ${1}"

       models.add(model)

        adapter.setData(models)
    }

    fun itemAdd(user:User){

        var modelsSize =models.size

        for(i in 0 until user.title.toInt()){

            var model=User()
            model.description="Description  ${i+modelsSize+1}"
            model.title="${i+modelsSize+1}"

            models.add(model)

        }
            adapter.setData(models)
    }

    fun onOptionsButtonClick(view: View,position: Int){


        val optionsMenu :PopupMenu = PopupMenu(this,view)

        var menuInflater =  optionsMenu.menuInflater

        menuInflater.inflate(R.menu.menu_item_options,optionsMenu.menu)

        optionsMenu.setOnMenuItemClickListener {
            when(it.itemId){

                R.id.itemAdd ->{

                    var model =User()
                    model.title="${models.size+1}"
                    model.description="Description ${models.size+1}"

                    models.add(model)
                    adapter.setData(models)
                }

                R.id.itemDelete ->{

                removeItemClicked(position)

                }
            }

            return@setOnMenuItemClickListener true

        }

        optionsMenu.show()

    }

    private fun removeItemClicked(position:Int) {
       var size =models.get(position)
        var position =models.indexOf(size)

        adapter.removeItem(position)




    }

}
