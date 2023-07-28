//Rect class
class Rect{
  //Fields
  private double length;
  private double width;

  //Default constructor
  public Rect(){
    length = 5;
    width = 5;
  }

  //Overloaded constructor
  public Rect (double l, double w){
    //If statements to set fields to default values if there's invalid values from arguments
    if (l<=0){
      length = 5;
    }
    else{
      length = l;
    }
    if (w<=0){
      width = 5;
    }
    else{
      width = w;
    }
  }

  //Accessor method to get the value to length
  public double getLength(){
    return length;
  }

  //Accessor method to get the value for width
  public double getWidth(){
    return width;
  }

  //Mutator method to change the length value
  public void setLength(double l){
    //If statement to throw arguments if invalid values are used
    if (l<=0){
      throw new IllegalArgumentException("Please enter a length that is greater than 0.");
    }
    else{
      length = l;
    }
  }

  //Mutator method to change the width value
  public void setWidth(double w){
    //If statement to throw arguments if invalid values are used
    if (w<=0){
      throw new IllegalArgumentException("Please enter a width that is greater than 0.");
    }
    else{
      width = w;
    }
  }

  //Method to return the area of the rectangle
  public double area(){
    return (length*width);
  }

  //Method to return the perimeter of the rectangle
  public double perimeter(){
    return(2*(length+width));
  }

  //Method to the diagnol of the rectangle
  public double diagnol(){
    return(Math.sqrt((Math.pow(length,2)+Math.pow(width, 2))));
  }

  //Method to change the length and width of the rectangle at the same time
  public void resize(double l, double w){
    //If statement to throw arguments if invalid values are used
    if (l<=0 || w<=0){
      throw new IllegalArgumentException("Please ensure that BOTH the length and width are greater than 0.");
    }
    else{
      length = l;
      width = w;
    }
  }

}