//Including the headers we require
#include <stdio.h>
#include <stdlib.h>

//Including the new type we are going to use
typedef int* triangular;

//Including the declaration of every function we define
int store(triangular as, int N, int row, int col, int val);
int fetch(triangular as, int N, int row, int col);
triangular newarray(int N);

//Defining the functions
triangular newarray(int N) {
    int size = (N*N-N)/2 + N;
    return (int*) malloc(sizeof(int)* size);
}

int store(triangular as, int N, int row, int col, int val) {
    if((col < row) || (row >= N) || (col >= N))
        return -1;

    as[row*N-(row)*(row+1)/2 + col] = val;
    return 1;

}

int fetch(triangular as, int N, int row, int col) {
    if((col < row) || (row >= N) || (col >= N))
        return -1;

    return as[row * N - (row) * (row + 1) / 2 + col];

}


/*int main() {
    triangular hello = newarray(3);
    store(hello, 3, 2, 2, 6);
    int e = store(hello, 3, 1, 1, 5);
    printf("%d", fetch(hello, 3, 2, 2));
    return 0;
}*/
