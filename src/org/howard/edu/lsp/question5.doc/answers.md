Heuristic 1:
Name:
Keep data and behavior together (encapsulation)

Explanation:
This improves maintainability by ensuring that a class is responsible for managing its own data instead of exposing it to outside classes. In lecture, this was illustrated by showing that when data is modified directly from outside, it can lead to bugs and inconsistent state, whereas encapsulation keeps control within the class.

Heuristic 2:
Name:
Hide implementation details (information hiding)

Explanation:
This improves readability by allowing other developers to use a class without needing to understand how it works internally. In lecture, this was explained by comparing public vs private methods, emphasizing that only necessary methods should be exposed while helper methods should remain private.

Heuristic 3:
Name:
A class should have a single, well-defined responsibility

Explanation:
This improves maintainability by making code easier to understand and modify without affecting unrelated functionality. In lecture, this was illustrated by breaking larger classes into smaller ones, where each class handled one specific task instead of multiple unrelated behaviors.
