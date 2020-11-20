package nl.leonw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
   public static void main(String[] args) {
      new AnnotationConfigApplicationContext(Config.class);
      System.out.println("------The End--------" );
   }
}
