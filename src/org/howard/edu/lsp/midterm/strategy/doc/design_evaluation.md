# Design Evaluation

The original PriceCalculator class has several design issues that make it difficult to maintain and extend. The use of multiple if statements to determine the customer type creates a rigid structure where adding new customer types requires modifying the existing code. This violates the Open/Closed Principle, which states that a class should be open for extension but closed for modification.

The design also suffers from poor scalability. As more customer types and discount rules are introduced, the number of conditional statements will continue to grow, making the code harder to read and manage. Additionally, the class is tightly coupled to specific string values and discount logic, which reduces flexibility and reusability.

Another issue is that the class violates the Single Responsibility Principle. It is responsible for both determining the type of customer and applying the corresponding discount logic, rather than separating these concerns into different components. This makes the code harder to test and maintain.

The refactored design using the Strategy Pattern resolves these issues by separating each discount behavior into its own class. This allows new discount types to be added without modifying existing code, improves code organization, and makes the system more flexible and easier to maintain.