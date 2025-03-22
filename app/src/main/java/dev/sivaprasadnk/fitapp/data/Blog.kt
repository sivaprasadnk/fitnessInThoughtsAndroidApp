package dev.sivaprasadnk.fitapp.data

data class Blog(
    val id: Int,
    val title: String?,
    val dateString: String?,
    val sub_title: String?,
    val content: String,
    val imageAssetPath: String,
    val image_network_path: String?,
    val isActive: Boolean,
    val isFeatured: Boolean,
    val cacheKey: String
)

val bloggs = listOf<Blog>(
    Blog(1, "### **Nourish to Flourish: The Essential Guide to a Balanced Diet** \uD83D\uDE0A\uD83E\uDD57\uD83C\uDF4E", "Jan 1, 2025", "A balanced diet is the foundation of a healthy lifestyle. It not only fuels your workouts but also ensures your body gets the essential nutrients it needs to function optimally. Whether your goal is weight management, muscle gain, or simply staying healthy, a thoughtful approach to your diet can make all the difference. Prioritizing whole, nutrient-dense foods helps improve energy levels and overall well-being. \uD83C\uDF4E\uD83E\uDD66\uD83D\uDCAA", "### Why Diet Matters\n" +
            "\n" +
            "Your diet plays a crucial role in: \uD83C\uDF4E\uD83D\uDCA8\uD83C\uDF3F\n" +
            "- **Providing Energy**: Supplying the fuel your body needs for daily activities and exercise.\n" +
            "- **Supporting Recovery**: Helping repair muscles and tissues post-workout.\n" +
            "- **Boosting Immunity**: Strengthening your body's defenses against illnesses.\n" +
            "- **Improving Mental Clarity**: Enhancing focus, memory, and overall brain function.\n" +
            "\n" +
            "### Components of a Balanced Diet\n" +
            "\n" +
            "#### 1. **Proteins**\n" +
            "\n" +
            "Proteins are the building blocks of the body. They help in muscle repair and growth. Include sources like: \uD83C\uDF54\uD83E\uDD5C\uD83C\uDF4F\n" +
            "- Lean meats (chicken, turkey, fish)\n" +
            "- Plant-based proteins (tofu, lentils, chickpeas)\n" +
            "- Dairy products (yogurt, cheese, milk)\n" +
            "- Eggs and nuts\n" +
            "\n" +
            "#### 2. **Carbohydrates**\n" +
            "\n" +
            "Carbs are your body's primary energy source. Choose complex carbs like: \uD83E\uDD5E\uD83C\uDF3E\uD83C\uDF53\n" +
            "- Whole grains (brown rice, quinoa, oats)\n" +
            "- Vegetables (sweet potatoes, broccoli, carrots)\n" +
            "- Legumes (beans, lentils)\n" +
            "\n" +
            "#### 3. **Fats**\n" +
            "\n" +
            "Healthy fats are essential for hormone regulation and brain health. Opt for: \uD83E\uDD51\uD83C\uDF36\uFE0F\uD83E\uDD52\n" +
            "- Avocados\n" +
            "- Nuts and seeds\n" +
            "- Olive oil\n" +
            "- Fatty fish (salmon, mackerel)\n" +
            "\n" +
            "#### 4. **Vitamins and Minerals**\n" +
            "\n" +
            "These micronutrients support various bodily functions. Include: \uD83C\uDF4B\uD83C\uDF3F\uD83C\uDF49\n" +
            "- Fruits (berries, oranges, bananas)\n" +
            "- Vegetables (spinach, kale, bell peppers)\n" +
            "- Nuts and seeds for trace minerals\n" +
            "\n" +
            "#### 5. **Hydration**\n" +
            "\n" +
            "Water is vital for every function in your body. Aim to drink at least 8 glasses a day and adjust based on activity levels. \uD83D\uDCA7\uD83C\uDF0A\uD83C\uDF27\uFE0F\n" +
            "\n" +
            "### Tips for Maintaining a Healthy Diet\n" +
            "\n" +
            "- **Plan Your Meals**: Prepare meals in advance to avoid unhealthy last-minute choices. \uD83D\uDCD3\uD83E\uDD62\uD83C\uDF72\n" +
            "- **Practice Portion Control**: Overeating even healthy foods can lead to weight gain. \uD83C\uDF2E\uD83D\uDC40\uD83C\uDF7D\uFE0F\n" +
            "- **Listen to Your Body**: Eat when you're hungry and stop when you're full. \uD83D\uDECC\uD83D\uDD0A\uD83E\uDDC3\n" +
            "- **Limit Processed Foods**: Avoid foods high in sugar, salt, and unhealthy fats. \uD83E\uDD67\uD83C\uDF08\uD83D\uDC94\n" +
            "- **Stay Consistent**: A single cheat meal won't derail your progress, but consistency is key. \uD83C\uDFCB\uFE0F\u200D♂\uFE0F\uD83D\uDCAA\uD83C\uDF5F\n" +
            "\n" +
            "### Final Thoughts\n" +
            "\n" +
            "A balanced diet is not about deprivation—it’s about making mindful choices that nourish your body and mind. Combine good nutrition with regular exercise and adequate sleep, and you’ll set yourself up for a healthier, happier life. Remember, you are what you eat—so choose wisely! \uD83C\uDF52\uD83D\uDC9C\uD83C\uDF6C", "", "https://firebasestorage.googleapis.com/v0/b/fitness-thoughts-bac27.firebasestorage.app/o/image5.jpg?alt=media&token=ee03c01d-7504-4a21-909e-01d5e62a7750", true, true, ""),
    Blog(2, "### **Nourish to Flourish: The Essential Guide to a Balanced Diet** \uD83D\uDE0A\uD83E\uDD57\uD83C\uDF4E", "Jan 1, 2025", "A balanced diet is the foundation of a healthy lifestyle. It not only fuels your workouts but also ensures your body gets the essential nutrients it needs to function optimally. Whether your goal is weight management, muscle gain, or simply staying healthy, a thoughtful approach to your diet can make all the difference. Prioritizing whole, nutrient-dense foods helps improve energy levels and overall well-being. \uD83C\uDF4E\uD83E\uDD66\uD83D\uDCAA", "### Why Diet Matters\n" +
            "\n" +
            "Your diet plays a crucial role in: \uD83C\uDF4E\uD83D\uDCA8\uD83C\uDF3F\n" +
            "- **Providing Energy**: Supplying the fuel your body needs for daily activities and exercise.\n" +
            "- **Supporting Recovery**: Helping repair muscles and tissues post-workout.\n" +
            "- **Boosting Immunity**: Strengthening your body's defenses against illnesses.\n" +
            "- **Improving Mental Clarity**: Enhancing focus, memory, and overall brain function.\n" +
            "\n" +
            "### Components of a Balanced Diet\n" +
            "\n" +
            "#### 1. **Proteins**\n" +
            "\n" +
            "Proteins are the building blocks of the body. They help in muscle repair and growth. Include sources like: \uD83C\uDF54\uD83E\uDD5C\uD83C\uDF4F\n" +
            "- Lean meats (chicken, turkey, fish)\n" +
            "- Plant-based proteins (tofu, lentils, chickpeas)\n" +
            "- Dairy products (yogurt, cheese, milk)\n" +
            "- Eggs and nuts\n" +
            "\n" +
            "#### 2. **Carbohydrates**\n" +
            "\n" +
            "Carbs are your body's primary energy source. Choose complex carbs like: \uD83E\uDD5E\uD83C\uDF3E\uD83C\uDF53\n" +
            "- Whole grains (brown rice, quinoa, oats)\n" +
            "- Vegetables (sweet potatoes, broccoli, carrots)\n" +
            "- Legumes (beans, lentils)\n" +
            "\n" +
            "#### 3. **Fats**\n" +
            "\n" +
            "Healthy fats are essential for hormone regulation and brain health. Opt for: \uD83E\uDD51\uD83C\uDF36\uFE0F\uD83E\uDD52\n" +
            "- Avocados\n" +
            "- Nuts and seeds\n" +
            "- Olive oil\n" +
            "- Fatty fish (salmon, mackerel)\n" +
            "\n" +
            "#### 4. **Vitamins and Minerals**\n" +
            "\n" +
            "These micronutrients support various bodily functions. Include: \uD83C\uDF4B\uD83C\uDF3F\uD83C\uDF49\n" +
            "- Fruits (berries, oranges, bananas)\n" +
            "- Vegetables (spinach, kale, bell peppers)\n" +
            "- Nuts and seeds for trace minerals\n" +
            "\n" +
            "#### 5. **Hydration**\n" +
            "\n" +
            "Water is vital for every function in your body. Aim to drink at least 8 glasses a day and adjust based on activity levels. \uD83D\uDCA7\uD83C\uDF0A\uD83C\uDF27\uFE0F\n" +
            "\n" +
            "### Tips for Maintaining a Healthy Diet\n" +
            "\n" +
            "- **Plan Your Meals**: Prepare meals in advance to avoid unhealthy last-minute choices. \uD83D\uDCD3\uD83E\uDD62\uD83C\uDF72\n" +
            "- **Practice Portion Control**: Overeating even healthy foods can lead to weight gain. \uD83C\uDF2E\uD83D\uDC40\uD83C\uDF7D\uFE0F\n" +
            "- **Listen to Your Body**: Eat when you're hungry and stop when you're full. \uD83D\uDECC\uD83D\uDD0A\uD83E\uDDC3\n" +
            "- **Limit Processed Foods**: Avoid foods high in sugar, salt, and unhealthy fats. \uD83E\uDD67\uD83C\uDF08\uD83D\uDC94\n" +
            "- **Stay Consistent**: A single cheat meal won't derail your progress, but consistency is key. \uD83C\uDFCB\uFE0F\u200D♂\uFE0F\uD83D\uDCAA\uD83C\uDF5F\n" +
            "\n" +
            "### Final Thoughts\n" +
            "\n" +
            "A balanced diet is not about deprivation—it’s about making mindful choices that nourish your body and mind. Combine good nutrition with regular exercise and adequate sleep, and you’ll set yourself up for a healthier, happier life. Remember, you are what you eat—so choose wisely! \uD83C\uDF52\uD83D\uDC9C\uD83C\uDF6C", "", "https://firebasestorage.googleapis.com/v0/b/fitness-thoughts-bac27.firebasestorage.app/o/image5.jpg?alt=media&token=ee03c01d-7504-4a21-909e-01d5e62a7750", true, true, "")
)
