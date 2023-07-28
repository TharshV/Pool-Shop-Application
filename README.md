# Pool-Shop-Application
A text based application that uses object-oriented programming principles to calculate pricing of a pool based on user input.

This program involves using a Rect class that has member functions such as:
- setLength - Takes an argument to set the length of a rectangle
- setWidth - Takes an arugment to set the width of a rectangle
- getLength - Returns the value of the length
- getWidth - Returns the value of the width
- area - Calculates and returns area
- perimeter - Calculates and returns perimeter
- diagnol - Calculate and returns diagnol length of a rectangle
- resize - Accepts two arguments to set values for length and width

The program performs calculations based on these requirements/price breakdowns:
- Each pool has a 6-foot wide concrete walkway surrounding the pool edge and the entire area must be enclosed by a fence
- Cost of fencing is $10.00 per linear foot
- Cost for concrete is $1.80 per square foot
- Cost for a small swimming pool is $20,540.00 (any pool with a recatangular area of 140 sq ft. or less)
- Cost for a large swimming pool is $39,320.00 (any pool wi a rectangular area of 140 sq ft. or more)
- A discount of 20% on the total price will be applied if 3 or more pools are bought in the same order. 

The program begins by prompting the user for dimensions of the swimming pool. The program then displays the following information:
- The amount of concrete required (sq. ft)
- The price of concrete
- The linear length of the fence
- The price of the fence

The program then provides the option to confirm/modify the pool.

Choosing modify will result in prompting the user to enter new dimensions. The program then reprints the above price breakdown with new calculations. The program will ask the user again to confirm/modify.

Choosing confirm will result in displaying the total price (including tax) and a receipt will be generated and placed in a text file.
