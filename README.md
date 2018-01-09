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
13) ResourceAccess: shows access to resources from another module
14) ModuleApi: shows usage of modular API.
15) ModuleAnnotation: annotated module example
16) LayerInfo: module which has class printing layer info. 
Used in ModuleApi
17) JshellDemo: module showing usage of Jshell API
18) ProcessDemo: Process API examples
19) CollectionsDemo: Updates to Java Collections

ModuleApi includes:

- FindModule: find module by path
- LayerTest: show layer information for required module
- LoadClass: load class from required module
- Module: print module for module and required ones
- QueryModule: check if module open and exported
- ReadModuleContents: show resources of specified module
- HttpDemo: HTTP/2 demo usage

ProcessDemo includes:

- CurrentProcessInfo: show info about current process
- Job:  a job which sleeps at a regular interval up to a max duration.Interval and duration can be set as parameters on start
- StartProcess: run a new process (uses Job class)
- ProcessStats: obtain a process handle and show some stats
- ManagingProcessPermission: working with permissions

CollectionsDemo includes:

- ListDemo: new way of creating unmodifiable lists
- SetDemo: new way of creating unmodifiable sets
- MapDemo: new way of creating unmodifiable maps

HttpDemo includes:

- GoogleHeaders: connect to google.com, get response code and headers

Build and run Java 9 module:
```yaml
      mvn clean install 
      
      java --module-path <path-to-target>/<maven-module-name>.jar -m <jigsaw-module-name>/<package-name>.<main-class>
      
      or if there are many modules
      
       java --module-path <path-to-target>/<maven-module-name>.jar:<path-to-target>/<maven-module-name>.jar
        -m <jigsaw-module-name>/<package-name>.<main-class>
   ```
   As far as I understand one maven module can have only one java module 
   
Classic biuld and run:

```yaml

   mvn clean install
   
   java -jar <path-to-target>/<jar-name>.jar
```   

Before build change main class name in pom for the demo you want to run 