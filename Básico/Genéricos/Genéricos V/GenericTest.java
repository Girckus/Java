import java.util.*;

public class GenericTest
{
  public static void main(String[] args)
  {
    List<List<?>> lists = new ArrayList<List<?>>();
    lists.add(Arrays.asList(1,2,3));
    lists.add(Arrays.asList("four","five"));
    
    List<Integer> list1 = new ArrayList<Integer>();
    putObj(4, list1);
    putNull(list1);
    
    System.out.println(getObject(list1));
    
    reverse(list1);
    
    System.out.println(getObject(list1));
  }
  
  public static <T> void putObj(T obj, List<? super T> list)
  {
    list.add(obj);
  }
  
  public static <T> T getObj(List<? extends T> list)
  {
    if(list.size() != 0)
    {
      return list.get(0);
    }
    else
      return null;
  }
  
  public static <T> void putNull(List<? extends T> list)
  {
    list.add(null);
  }
  
  public static <T> Object getObject(List<? super T> list)
  {
    if(list.size() != 0)
    {
      return (Object)list.get(0);
    }
    else
      return null;
  }
  
  public static void reverse(List<?> list) { rev(list); }
  
  private static <T> void rev(List<T> list) 
  {
    List<T> tmp = new ArrayList<T>(list);
    for (int i = 0; i < list.size(); i++) {
      list.set(i, tmp.get(list.size()-i-1));
  }
}

}