package com.example.mealsfinder

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {

    var addMealsDB: Button? = null
    var searchMealsByIngredient: Button? = null
    var searchForMeals: Button? = null
    var searchMealsFromWebservice: Button? = null
    private lateinit var mealsDao: MealsDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the MealDatabase and MealsDao
        val db = Room.databaseBuilder(this, MealDatabase::class.java, "meal-db").build()
        mealsDao = db.mealDao()

        // Initialize the buttons
        addMealsDB = findViewById(R.id.button1)
        searchMealsByIngredient = findViewById(R.id.button2)
        searchForMeals = findViewById(R.id.button3)
        searchMealsFromWebservice =findViewById(R.id.button4)

        // Enable the addMealsDB button
        addMealsDB?.isEnabled = true

        // Set click listeners for the buttons
        addMealsDBButton()
        searchMealsByIngredientButton()
        searchForMealsButton()
        searchMealsFromWebServiceButton()

    }

    // Handle the click event for the addMealsDB button
    private fun addMealsDBButton() {
        addMealsDB?.setOnClickListener {
            // Use coroutines to perform the database insertion on a separate thread
            runBlocking {
                launch {
                    // Create Meals objects representing different meals
                    val meal1 = Meals(
                        0,
                        "Sweet and Sour Pork",
                        null,
                        "Pork",
                        "Chinese",
                        "Preparation: ...",
                        "https://www.themealdb.com/images/media/meals/1529442316.jpg",
                        "Sweet",
                        "https://www.youtube.com/watch?v=mdaBIhgEAMo",
                        listOf(
                            "Pork",
                            "Egg",
                            "Water",
                            "Salt",
                            "Sugar",
                            "Soy Sauce",
                            "Starch",
                            "Tomato Puree",
                            "Vinegar",
                            "Coriander"
                        ),
                        listOf(
                            "200g",
                            "1",
                            "Dash",
                            "1/2 tsp",
                            "1 tsp",
                            "10g",
                            "10g",
                            "30g",
                            "10g",
                            "Dash"
                        ),
                        null,
                        null,
                        null,
                        null
                    )

                    val meal2 = Meals(
                        0,
                        "Chicken Marengo",
                        null,
                        "Chicken",
                        "French",
                        "\"Heat the oil in a large flameproof casserole dish and stir-fry the mushrooms until they start to soften. Add the chicken legs and cook briefly on each side to colour them a little.\\r\\nPour in the passata, crumble in the stock cube and stir in the olives. Season with black pepper \\u2013 you shouldn\\u2019t need salt. Cover and simmer for 40 mins until the chicken is tender. Sprinkle with parsley and serve with pasta and a salad, or mash and green veg, if you like.\"",
                        "https://www.themealdb.com/images/media/meals/qpxvuq1511798906.jpg",
                        null,
                        "https://www.youtube.com/watch?v=U33HYUr-0Fw",
                        listOf(
                            "Olive Oil",
                            "Mushrooms",
                            "Chicken Legs",
                            "Passata",
                            "Chicken Stock Cube",
                            "Black Olives",
                            "Parsley"
                        ),
                        listOf(
                            "1 tbs",
                            "300g",
                            "4",
                            "500g",
                            "1",
                            "100g ",
                            "Chopped"
                        ),
                        "https://www.bbcgoodfood.com/recipes/3146682/chicken-marengo",
                        null,
                        null,
                        null
                    )

                    val meal3 = Meals(
                        0,
                        "Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber",
                        null,
                        "Beef",
                        "Vietnamese",
                        "Add'l ingredients: mayonnaise, siracha\r\n\r\n1\r\n\r\nPlace rice in a fine-mesh sieve and rinse until water runs clear. Add to a small pot with 1 cup water (2 cups for 4 servings) and a pinch of salt. Bring to a boil, then cover and reduce heat to low. Cook until rice is tender, 15 minutes. Keep covered off heat for at least 10 minutes or until ready to serve.\r\n\r\n2\r\n\r\nMeanwhile, wash and dry all produce. Peel and finely chop garlic. Zest and quarter lime (for 4 servings, zest 1 lime and quarter both). Trim and halve cucumber lengthwise; thinly slice crosswise into half-moons. Halve, peel, and medium dice onion. Trim, peel, and grate carrot.\r\n\r\n3\r\n\r\nIn a medium bowl, combine cucumber, juice from half the lime, \u00bc tsp sugar (\u00bd tsp for 4 servings), and a pinch of salt. In a small bowl, combine mayonnaise, a pinch of garlic, a squeeze of lime juice, and as much sriracha as you\u2019d like. Season with salt and pepper.\r\n\r\n4\r\n\r\nHeat a drizzle of oil in a large pan over medium-high heat. Add onion and cook, stirring, until softened, 4-5 minutes. Add beef, remaining garlic, and 2 tsp sugar (4 tsp for 4 servings). Cook, breaking up meat into pieces, until beef is browned and cooked through, 4-5 minutes. Stir in soy sauce. Turn off heat; taste and season with salt and pepper.\r\n\r\n5\r\n\r\nFluff rice with a fork; stir in lime zest and 1 TBSP butter. Divide rice between bowls. Arrange beef, grated carrot, and pickled cucumber on top. Top with a squeeze of lime juice. Drizzle with sriracha mayo.",
                        "https://www.themealdb.com/images/media/meals/z0ageb1583189517.jpg",
                        null,
                        " ",
                        listOf(
                            "Rice",
                            "Onion",
                            "Lime",
                            "Garlic Clove",
                            "Cucumber",
                            "Carrots",
                            "Ground Beef",
                            "Soy Sauce",
                            " "
                        ),
                        listOf(
                            "White",
                            "1",
                            "1",
                            "3",
                            "1",
                            "3 oz ",
                            "1 lb",
                            "2 oz "
                        ),
                        null,
                        null,
                        null,
                        null
                    )

                    val meal4 = Meals(
                        0,
                        "Leblebi Soup",
                        null,
                        "Vegetarian",
                        "Tunisian",
                        "Heat the oil in a large pot. Add the onion and cook until translucent.\r\nDrain the soaked chickpeas and add them to the pot together with the vegetable stock. Bring to the boil, then reduce the heat and cover. Simmer for 30 minutes.\r\nIn the meantime toast the cumin in a small ungreased frying pan, then grind them in a mortar. Add the garlic and salt and pound to a fine paste.\r\nAdd the paste and the harissa to the soup and simmer until the chickpeas are tender, about 30 minutes.\r\nSeason to taste with salt, pepper and lemon juice and serve hot.",
                        "https://www.themealdb.com/images/media/meals/x2fw9e1560460636.jpg",
                        "Soup",
                        "https://www.youtube.com/watch?v=BgRifcCwinY",
                        listOf(
                            "Olive Oil",
                            "Onion",
                            "Chickpeas",
                            "Vegetable Stock",
                            "Cumin",
                            "Garlic",
                            "Salt",
                            "Harissa Spice",
                            "Pepper",
                            "Lime"
                        ),
                        listOf(
                            "2 tbs",
                            "1 medium finely diced",
                            "250g",
                            "1.5L",
                            "5 cloves",
                            "1 tsp ",
                            "1/2 tsp",
                            "1 tsp ",
                            "Pinch",
                            "1/2 "

                        ),
                        "http://allrecipes.co.uk/recipe/43419/leblebi--tunisian-chickpea-soup-.aspx",
                        null,
                        null,
                        null
                    )
                    // Insert the meals into the database
                    mealsDao.insertMeals(meal1,meal2,meal3,meal4)
                }
            }
            // Display a toast message to indicate the meals have been added to the database
            Toast.makeText(this, "Meals Added To Database", Toast.LENGTH_SHORT).show()
        }
    }

    // Handle the click event for the searchMealsByIngredient button
    private fun searchMealsByIngredientButton() {
        searchMealsByIngredient?.setOnClickListener {
            // Create an intent to navigate to the SearchMealsByIngredient activity
            val mealsByIngredient = Intent(this, SearchMealsByIngredient::class.java)
            startActivity(mealsByIngredient)
        }
    }


    // Handle the click event for the searchForMeals button
    private fun searchForMealsButton() {
        searchForMeals?.setOnClickListener {
            // Create an intent to navigate to the SearchForMeals activity
            val searchMeals = Intent(this, SearchForMeals::class.java)
            startActivity(searchMeals)
        }
    }
//
    private fun searchMealsFromWebServiceButton() {
        searchMealsFromWebservice?.setOnClickListener {
            // Create an intent to navigate to the SearchForMeals activity
            val  searchMealsFromWeb = Intent(this, SearchMealsFromWebService::class.java)
            startActivity(searchMealsFromWeb)
        }
    }
}
