package com.example.menusample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {

    private var _menuList: MutableList<MutableMap<String, Any>> = mutableListOf()

    private val _from = arrayOf("name", "price")

    private val _to = intArrayOf(R.id.tvMenuNameRow, R.id.tvMenuPriceRow)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _menuList = createTeishokuList()

        val lvMenu: ListView = findViewById(R.id.lvMenu)

        val adapter = SimpleAdapter(this@MainActivity, _menuList, R.layout.row, _from, _to)

        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListener()

        registerForContextMenu(lvMenu)
    }
    private fun createTeishokuList(): MutableList<MutableMap<String, Any>> {
        val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()

        var menu = mutableMapOf<String, Any>("name" to "から揚げ定食", "price" to 800,
            "desc" to "若鶏のから揚げにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)

        menu = mutableMapOf<String, Any>("name" to "ハンバーグ定食", "price" to 850,
            "desc" to "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)

        menu = mutableMapOf<String, Any>("name" to "焼き肉定食", "price" to 1000,
            "desc" to "国産の肉を使用した焼き肉にサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)

        menu = mutableMapOf<String, Any>("name" to "麻婆豆腐定食", "price" to 750,
            "desc" to "あつあつの麻婆豆腐にサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)

        return menuList
    }
    private fun order(menu: MutableMap<String, Any>) {
        val menuName = menu["name"] as String
        val menuPrice = menu["price"] as Int

        val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)

        intent2MenuThanks.putExtra("menuName", menuName)
        intent2MenuThanks.putExtra("menuPrice", "${menuPrice}円")

        startActivity(intent2MenuThanks)
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val item = parent.getItemAtPosition(position) as MutableMap<String, Any>

            order(item)
        }
    }
}