# MPI(Message Passing Interface)

1. Mechanism to implement parallelism
2. MPJ express library is used to execute parallel Java Apps
3. MPJ express can be configured in 2 ways
   1. Multicore Configuration : Used to execute MPJ Express user programs on laptops and desktops.
   2. Cluster Configuration : Used to execute MPJ Express user programs on clusters or network of computers.

# Download MPJ Express

1. Download MPJ Express (mpj.jar) and unpack it: **mpjexpress.org**
2. Set environment variables MPJ_HOME and PATH:
   1. export MPJ_HOME=/path/to/mpj/
   2. export PATH=$ MPJ_HOME/bin:$PATH
   
# MPI Environment

1. `Communicator` - Central object for communication in MPI.
2. `MPI.Init()` - Initializes the MPI Environment.
3. `MPI.Finalize()` - Destroys the MPI Environment.
4. `MPI.COMM_WORLD.Size()` - Returns number of processes in Communicator.
5. `MPI.COMM_WORLD.Rank()` - Returns the rank of calling process.
6. `MPI.COMM_WORLD.Scatter(sendbuf, offset, chunksize, datatype, recvbuf, offset, chunksize, datatype, rootProcess)` - Scatters data amongst the processes of Communicator.
7. `MPI.COMM_WORLD.Gather(recvbuf, offset, chunksize, datatype, sendbuf, offset, chunksize, datatype, rootProcess)` - Gathers data from the processes of Communicator.


# Commands to Compile and Run the code
- Compile : `javac -source 1.8 -target 1.8 -cp $MPJ_HOME/lib/mpj.jar programName.java`
- Run : `$MPJ_HOME/bin/mpjrun.sh -np 4 programName` 