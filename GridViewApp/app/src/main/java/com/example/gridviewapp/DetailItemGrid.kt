package com.example.gridviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

private lateinit var ivImg:ImageView;
private lateinit var tvName:TextView;
private lateinit var tvDepartment:TextView;
class DetailItemGrid : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_item_grid)
        ivImg = findViewById(R.id.detail_img_id);
        tvName =findViewById(R.id.detail_name);
        tvDepartment = findViewById(R.id.detail_department);

        val bundle:Bundle = intent.extras!!;

        ivImg.setImageResource(bundle.getInt("detailImg"));
        tvName.setText(bundle.getString("detailName"));
        tvDepartment.setText(bundle.getString("detailDepartment"));
    }
}