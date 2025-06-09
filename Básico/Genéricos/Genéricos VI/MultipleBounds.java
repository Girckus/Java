public class MultipleBounds
{
  public static class Class1 implements Foo, Bar
  {
    public void doFoo()
    {
      System.out.println("doFoo");
    }
    
    public void doBar()
    {
      System.out.println("doBar");
    }
  }
  
  public static class Class2 implements Foo
  {
    public void doFoo()
    {
      System.out.println("doFoo 2");
    }
  }
  
  public static <E extends Foo & Bar> void doSomething(E obj)
  {
    obj.doFoo();
    obj.doBar();
  }
  
  public static void main(String[] args)
  {
    MultipleBounds.doSomething(new Class1());
    //MultipleBounds.doSomething(new Class2());
  }
}