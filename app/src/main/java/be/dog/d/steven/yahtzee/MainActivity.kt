package be.dog.d.steven.yahtzee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage1 : ImageView
    private lateinit var diceImage2 : ImageView
    private lateinit var diceImage3 : ImageView
    private lateinit var diceImage4 : ImageView
    private lateinit var diceImage5 : ImageView

    private lateinit var lockImage1 : ImageView
    private lateinit var lockImage2 : ImageView
    private lateinit var lockImage3 : ImageView
    private lateinit var lockImage4 : ImageView
    private lateinit var lockImage5 : ImageView

    private var dice1 : Boolean = true
    private var dice2 : Boolean = true
    private var dice3 : Boolean = true
    private var dice4 : Boolean = true
    private var dice5 : Boolean = true

    private var turn = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Button view from the layout and assign a click listener for button
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        // Get image view from the layout for dice and locks
        diceImage1 = findViewById(R.id.imageView1)
        diceImage2 = findViewById(R.id.imageView2)
        diceImage3 = findViewById(R.id.imageView3)
        diceImage4 = findViewById(R.id.imageView4)
        diceImage5 = findViewById(R.id.imageView5)

        lockImage1 = findViewById(R.id.lockImageView1)
        lockImage2 = findViewById(R.id.lockImageView2)
        lockImage3 = findViewById(R.id.lockImageView3)
        lockImage4 = findViewById(R.id.lockImageView4)
        lockImage5 = findViewById(R.id.lockImageView5)

        /**
         * Assign on click listener and lock/unlock dices on click
         */
        diceImage1.setOnClickListener{
            if (dice1){
                lockImage1.setImageResource(R.drawable.ic_lock)
            }else {
                lockImage1.setImageResource(R.drawable.empty_dice)
            }
            dice1 = !dice1
        }
        diceImage2.setOnClickListener{
            if (dice2){
                lockImage2.setImageResource(R.drawable.ic_lock)
            }else {
                lockImage2.setImageResource(R.drawable.empty_dice)
            }
            dice2 = !dice2
        }
        diceImage3.setOnClickListener{
            if (dice3){
                lockImage3.setImageResource(R.drawable.ic_lock)
            }else {
                lockImage3.setImageResource(R.drawable.empty_dice)
            }
            dice3 = !dice3
        }
        diceImage4.setOnClickListener{
            if (dice4){
                lockImage4.setImageResource(R.drawable.ic_lock)
            }else {
                lockImage4.setImageResource(R.drawable.empty_dice)
            }
            dice4 = !dice4
        }
        diceImage5.setOnClickListener{
            if (dice5){
                lockImage5.setImageResource(R.drawable.ic_lock)
            }else {
                lockImage5.setImageResource(R.drawable.empty_dice)
            }
            dice5 = !dice5
        }
    }

    /**
     * Roll dice or reset after 3 turns
     */
    private fun rollDice() {
        if (turn <3) {
            if (dice1) {
                diceImage1.setImageResource(getRandomDiceImage())
            }
            if (dice2) {
                diceImage2.setImageResource(getRandomDiceImage())
            }
            if (dice3) {
                diceImage3.setImageResource(getRandomDiceImage())
            }
            if (dice4) {
                diceImage4.setImageResource(getRandomDiceImage())
            }
            if (dice5) {
                diceImage5.setImageResource(getRandomDiceImage())
            }

            turn++
        }else{
            diceImage1.setImageResource(R.drawable.empty_dice)
            diceImage2.setImageResource(R.drawable.empty_dice)
            diceImage3.setImageResource(R.drawable.empty_dice)
            diceImage4.setImageResource(R.drawable.empty_dice)
            diceImage5.setImageResource(R.drawable.empty_dice)

            lockImage1.setImageResource(R.drawable.empty_dice)
            lockImage2.setImageResource(R.drawable.empty_dice)
            lockImage3.setImageResource(R.drawable.empty_dice)
            lockImage4.setImageResource(R.drawable.empty_dice)
            lockImage5.setImageResource(R.drawable.empty_dice)

            dice1 = true
            dice2 = true
            dice3 = true
            dice4 = true
            dice5 = true

            turn = 0
        }
    }

    /**
     * Get random int for dice roll and pass the right image view
     */
    private fun getRandomDiceImage() : Int {
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}