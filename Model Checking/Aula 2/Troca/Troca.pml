#define MAX 10
active proctype Troca(){
    int a = 1, b = 1,aa = 0,bb = 0;
    do
    :: a < MAX -> a++;
    :: break
    od;
    aa = a;
 
    assert(a <= MAX && a >= 1);
    do
    :: b < MAX -> b++;
    :: break
    od;
    bb = b;
    assert(b <= MAX && b >= 1);
    
    if
    :: a == 3 && b == 7 -> assert(a!=3 && b!=7)
    :: else -> skip
    fi;


    a = a - b; /* -28 */
    b = a + b; /* 3   */
    a = b - a; /* 31  */

    

    assert(a == bb && b == aa);

}