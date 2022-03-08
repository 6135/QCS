byte a = 3
active [4] proctype P() {
	if
	:: a >= 3 -> 
		a = a - 1; 
		printf("1st proc_id: %d a:%d\n",_pid,a);
	:: a >= 2 -> 
		a = a + 1; 
		printf("2st proc_id: %d %d\n",_pid,a);
	:: else -> skip;
	fi
	
}

