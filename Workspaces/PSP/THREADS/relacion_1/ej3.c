#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
#include <stdlib.h>

#define MATRIX_COLS 5
#define MATRIX_FILAS 5

const int matrix[MATRIX_FILAS][MATRIX_COLS] =
{
    {4,7,2,8,1},
    {5,7,3,6,4},
    {5,6,4,7,2},
    {6,4,7,3,7},
    {4,6,1,3,2}
};

void* suma_fila(void *arg)
{
    int *num_fila = (int *)&arg;
    int *suma_total = malloc(sizeof(int));
    int i;
    for(i = 0; i <MATRIX_COLS; i++)
    {
        suma_total += matrix[*num_fila][i];
    }
    pthread_exit((void *) suma_total);
}



int main(void)
{
    pthread_t thread;
    int i;
    int resultado_fila;
    int *resultado_total;
    for(i = 0; i <MATRIX_FILAS; i++)
    {
        pthread_create(&thread, NULL, &suma_fila, NULL);
        pthread_join(thread, (void **) &resultado_total);
        printf("%d\n", *resultado_total);
    }
    return 0;
}
