# Java9Demo

Java 9 new features


The Project is split into several maven modules.


1) Intro : basic Java 9 module demo. 

   Build and run:
   ```yaml
      mvn clean install 
      java --module-path target/Intro-1.0.jar -m org.abondar.experimental.intro/org.abondar.experimental.intro.Welcome
   ```
   As far as I understand one maven module can have only one java module 