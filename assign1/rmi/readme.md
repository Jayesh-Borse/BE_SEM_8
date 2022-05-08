# RMI

1. Remote Method Invocation (RMI) is an API that allows an object to invoke a method on an object that exists in another address space, which could be on the same machine or on a remote machine.

2. Through RMI, an object running in a JVM present on a computer (Client-side) can invoke methods on an object present in another JVM (Server-side).

3. RMI creates a public remote server object that enables client and server-side communications through simple method calls on the server object.

4. These are the steps to be followed sequentially to implement Interface as defined below as follows:
   - Defining a remote interface
     - Declare functions that remote can access
   - Implementing the remote interface
     - Define the remote functions 
     - The methods needed to create remote objects and make them available to remote clients are provided   by the class *UnicastRemoteObject*.
   - Creating Stub and Skeleton objects from the implementation class using rmic (RMI compiler)
     - Use command `rmic nameOfTheClassImplementingInterface`
   - Create and execute the server application program
     - create registry <br>
        `LocateRegistry.createRegistry(portNumber)`
     - rebind interface object to localhost <br>
        `Naming.rebind(localhost, interfaceObj)`
   - Create and execute the client application program 
     - Lookup for remotrObj <br>
        `Naming.lookup(localhost)`