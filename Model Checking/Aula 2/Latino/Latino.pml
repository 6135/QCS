active proctype Latino(){
    int size = 3;
    int mat[9];
    int value=1,j;
    for (j : 0 .. 9) 
    {
        do
        :: value < 3 -> value++;
        :: break
        od;

        mat[j] = value; 
        j++;
        value = 1;
        
    }
    printf("%d %d %d\n %d %d %d\n %d %d %d\n",mat[0],mat[1],mat[2],mat[3],mat[4],mat[5],mat[6],mat[7],mat[8]);


}