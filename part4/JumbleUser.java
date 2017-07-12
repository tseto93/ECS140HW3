public class JumbleUser{

  public static int lengthLongestNDCSS1(Jumble j){
    int length = 0, cval = 0, nval = 0, temp = 0;
    JumbleIt jIt = new JumbleIt(j);

    if(itr.hasNext()){
      cur = next = itr.next();
      temp++;
      length++;
    }

    while(jIt.hasNext()){
      nval = jIt.next();
      if(nval >= cval)
        temp++;
      else
        temp = 1;
      if(temp > length)
        length = temp;
        cval = nval;

      }
      return length;
  }

}

