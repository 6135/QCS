#define N 5
active proctype Q(){
	int i = 1, result = 0;
	int supposedRes = ((N*N)+N)/2;
	do
	:: i <= N -> {
			result = result + i;
			printf("Sum: %d\n",result);
			i++;
		}
	:: else -> break;
	od;
	printf("Sum: %d\n",result);
	/* Comment */

	assert (result == supposedRes);

}