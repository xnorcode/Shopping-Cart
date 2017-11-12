# Shopping Cart Android App (MVP)

Simple shopping cart android app that aims to demonstrate the MVP design

## Getting Started

Download a copy of this project

### Explanation

View:
responsible for the view only in this case the main activity, passes items to the presenter for the logic

Presenter:
Receives the items in a hashmap and creates the text that will be the cart view and sends the selected items to the model to get to total cost.

Model:
has data about each item and calculates how much will be the total.

In this design we have an absolute separation in the above mentioned 3 layers and
each layer has no information about the other layers.
