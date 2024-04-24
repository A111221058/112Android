package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup genderRadioGroup;
    RadioGroup ticketTypeRadioGroup;
    EditText quantityEditText;
    Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genderRadioGroup = findViewById(R.id.gender_radio_group);
        ticketTypeRadioGroup = findViewById(R.id.ticket_type_radio_group);
        quantityEditText = findViewById(R.id.quantity_edit_text);
        confirmButton = findViewById(R.id.confirm_button);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                int selectedTicketTypeId = ticketTypeRadioGroup.getCheckedRadioButtonId();
                String quantityString = quantityEditText.getText().toString();

                if (selectedGenderId == -1 || selectedTicketTypeId == -1 || quantityString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
                RadioButton selectedTicketTypeRadioButton = findViewById(selectedTicketTypeId);
                int quantity = Integer.parseInt(quantityString);

                // Calculate total amount
                int ticketPrice = 0;
                String ticketType = ((RadioButton) findViewById(ticketTypeRadioGroup.getCheckedRadioButtonId())).getText().toString();
                switch (ticketType) {
                    case "Student Ticket ($400)":
                        ticketPrice = 400;
                        break;
                    case "Child Ticket ($250)":
                        ticketPrice = 250;
                        break;
                    case "Adult Ticket ($500)":
                        ticketPrice = 500;
                        break;
                }

                int totalAmount = ticketPrice * quantity;

                // Start ResultActivity and pass data
                Intent intent = new Intent(MainActivity.this, secondactivity.class);
                intent.putExtra("gender", selectedGenderRadioButton.getText().toString());
                intent.putExtra("ticketType", selectedTicketTypeRadioButton.getText().toString());
                intent.putExtra("quantity", quantity);
                intent.putExtra("totalAmount", totalAmount);
                startActivity(intent);
            }
        });
    }
}

