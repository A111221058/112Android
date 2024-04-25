package com.example.buttonhw_a111221058;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class secondactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity_main );

        Intent intent = getIntent();
        String gender = intent.getStringExtra("gender");
        String ticketType = intent.getStringExtra("ticketType");
        int quantity = intent.getIntExtra("quantity", 0);
        int totalAmount = intent.getIntExtra("totalAmount", 0);

        TextView genderTextView = findViewById(R.id.gender_text_view);
        TextView ticketTypeTextView = findViewById(R.id.ticket_type_text_view);
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        TextView totalAmountTextView = findViewById(R.id.total_amount_text_view);

        genderTextView.setText("性別: " + gender);
        ticketTypeTextView.setText("票種: " + ticketType);
        quantityTextView.setText("張數: " + quantity);
        totalAmountTextView.setText("總金額: $" + totalAmount);
    }
}
