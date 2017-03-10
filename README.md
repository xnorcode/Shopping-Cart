# MVP-Android-Example - SHOPPING CART ANDROID APP

ShoppingCart app is an sample that demonstrates how the MVP architecture works

## Getting Started

Download a copy of this project

### Explanation

View:
checks the view only in this case the main activity view and passes items to the presenter for further action

Presenter:
Receives the items in a hashmap form and creates the text that will be the cart view
Also sends the items selected to be added to the view to the model to get to total cost.

Model:
has data about each item and calculates how much will be the total.

In this architecture we have an absolute separation in the above mentioned 3 layers and
each layer has no information about the other layers.
