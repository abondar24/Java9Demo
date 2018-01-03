# Java9Demo

Java 9 new features


The Project is split into several maven modules.


1) Intro : basic Java 9 module demo. 
2) Address: small module required by Person
3) Person: small module showing module dependency between each other
4) Relect: example of open module
5) Reflect: module using deep reflection to open module
6) Prime: service module
7) PrimeFast: provider of prime
8) PrimeGeneric: provider of prime
9) PrimeProbable: provider of prime
10) PrimeClient: client of Prime Service
11) Version: showing correct and incorrect version strings for JDK 9
12) Resources: resources to be accessed from ResourceAccess module
13) ResourceAccess: show access to resources from another module


Build and run:
```yaml
      mvn clean install 
      
      java --module-path <path-to-target>/<maven-module-name>.jar -m <jigsaw-module-name>/<package-name>.<main-class>
      
      or if there are many modules
      
       java --module-path <path-to-target>/<maven-module-name>.jar:<path-to-target>/<maven-module-name>.jar
        -m <jigsaw-module-name>/<package-name>.<main-class>
   ```
   As far as I understand one maven module can have only one java module 