import org.scalatest.FunSuite                       
                                                    
class MainTest extends FunSuite {                   
  test("helloWorld") {                              
    import org.example._                            
    assert(Main.helloWorld("Taro") == "Hello Taro!")
  }                                                 
}                                                   
