package ics499.arithimagicians;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class InventoryActivity extends Activity {
    private int healthPotionCount;
    private Player player;
    private ArrayList<Item> inventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent getIntent = getIntent();
        player = (Player) getIntent.getSerializableExtra("player");
        setContentView(R.layout.activity_inventory);
        inventory = player.getInventory();
        setInventoryCount();


    }

    public void useHealthPotion(View view) {
        inventory.get(0).decrementValue();
        setInventoryCount();
    }

    public void closeClick(View view) {
        player.setInventory(inventory);
        Intent previous = new Intent(getApplicationContext(), DisplayMap.class);
        previous.putExtra("player", this.player);
        setResult(100, previous);
        this.finish();
    }

    public void setInventoryCount() {
        int healthPotion = inventory.get(0).getValue();
        TextView t = (TextView) findViewById(R.id.healthPotionTextView);
        t.setText(Integer.toString(healthPotion));
    }
}
