
public class Body{

  char head;
  char leftArm;
  char rightArm;
  char body;
  char leftLeg;
  char rightLeg;
  int lives;
  
  Body(){
    head = ' ';
    leftArm = ' ';
    rightArm = ' ';
    body = ' ';
    leftLeg = ' ';
    rightLeg= ' ';
    lives = 0;
  }

  public void incrementLives(){
    lives++;
    switch(lives){
      case 1:
        head = '0';
        break;
      case 2:
        leftArm = '/';
        break;
      case 3:
        body = '|';
        break;
      case 4:
        rightArm = '\\';
        break;
      case 5:
        leftLeg = '/';
        break;
      case 6:
        rightLeg = '\\';
        break;
    }
  }
  
  
}