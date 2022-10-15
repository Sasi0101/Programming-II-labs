//Including the headers we require
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//Declaring the function we are going to use
int scan(int *integral, double *decimal, double d);

//Defining the function we are going to use
int scan(int *integral, double *decimal, double d) {
    //Deciding the sign of d
    int sign;
    if(d < 0)
        sign = -1;
    else
        sign = 1;

    //Calculating the integralPart of d
    int integralPart = abs(d);
    *integral = integralPart;

    //Calculating the decimalPart of d (float absolute)
    double decimalPart = fabs(d) - integralPart;
    *decimal = decimalPart;

    return sign;
}

/*int main() {
    int sign;
    int integral;
    double decimal;
    sign = scan(&integral, &decimal, -48.25);
    printf("sign: %d\n", sign);
    printf("integral: %d\n", integral);
    printf("decimal: %.2lf\n", decimal);
    return 0;
}*/
