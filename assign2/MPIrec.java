import mpi.MPI;

public class MPIrec {

    public static void main(String []args) {

        MPI.Init(args);

        int size = MPI.COMM_WORLD.Size();
        int rank = MPI.COMM_WORLD.Rank();

        int root = 0;

        if(root == rank) {
            System.out.println("Size of Communicator is :: " + size);
        }
        System.out.println("The Rank of current process is :: " + rank);
        
        double sendbuf[] = new double[size];

        if(rank == root) {

            sendbuf[0] = 10;
            sendbuf[1] = 20;
            sendbuf[2] = 30;
            sendbuf[3] = 40;

            System.out.println("\nData to be scattered by process "+rank+": ");
			for(int i=0;i<size;i++)
			{

				System.out.print(sendbuf[i]+" ");
			}	
        }

        double recvbuf[] = new double[1];

        MPI.COMM_WORLD.Scatter(
                                sendbuf, 0, 2, MPI.DOUBLE, 
                                recvbuf, 0, 2, MPI.DOUBLE, 
                                root
                            );

        System.out.println("\nProcess "+rank+" has data: "+recvbuf[0]);		
		recvbuf[0] = 1/recvbuf[0];

        MPI.COMM_WORLD.Gather(
                                recvbuf, 0, 2, MPI.DOUBLE,
                                sendbuf, 0, 2, MPI.DOUBLE,
                                root
                            );
        
        if(rank == root) {
            System.out.println("\nThe root process "+rank+"has data: ");
            for(int i=0;i<size;i++)
                System.out.print(sendbuf[i]+" ");
        }

        MPI.Finalize();

    }

}

//javac -source 1.8 -target 1.8 -cp $MPJ_HOME/lib/mpj.jar MPIrec.java
//$MPJ_HOME/bin/mpjrun.sh -np 4 MPIrec