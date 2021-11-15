#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
/*

  */
int main(void)
{
  //Creamos la matriz de valores
  int matrix[4][4] = {{1,1,2,2},
                      {1,1,2,2},
                      {3,3,4,4},
                      {3,3,4,4}};

  int finmatrix[2][2];
  int matrixheight = sizeof(matrix) / sizeof(matrix[0]);
  int matrixwidth = sizeof(matrix) / sizeof(matrix[0]);
  pid_t pid;

  /* Pintamos la matriz original (opcional)*/
  printf("Matriz original:\n");
  for(int i = 0; i < matrixheight; i++)
  {
    for(int j = 0; j < matrixwidth; j++)
    {
      printf("%d\t", matrix[i][j]);
    }
    printf("\n");
  }
  printf("\n");

  /*Creamos la cantidad correcta de sub-matrices dividiendo la altura y anchura de la matriz original entre 2*/
  for(int i = 0; i < matrixheight; i+=2)
  {
    for(int j = 0; j < matrixwidth; j+=2)
    {
      /*Aqui creamos los procesos hijos*/
      pid = fork();
      /*Si el proceso es hijo, se encargará de operar una sub-matriz*/
      if(pid == 0)
      {
        for(int x = 0; x < matrixwidth; x+=2)
        {
          for(int y = 0; y < matrixheight; y+=2)
          {
            /*Demostración visual*/
            printf("Submatriz %d\n", i + j);
            printf("%d\t%d\n%d\t%d\n",matrix[i+x][j+y],matrix[i+x][j+y],matrix[i+x][j+y],matrix[i+x][j+y]);
            /*Creamos la sub-matriz y le asignamos los valores de las celdas correctas de la matriz original*/
            int pmatrix[2][2] = {{matrix[i+x][j+y],matrix[i+x][j+y]},{matrix[i+x][j+y],matrix[i+x][j+y]}};
            /*Calculamos la media de las celdas de la sub-matriz y devolvemos este valor*/
            int media = (pmatrix[0][0] + pmatrix[0][1] + pmatrix[1][0] + pmatrix[1][1]) / 4;
            exit(media);
          }
        }
      }
      /*Si el proceso es padre, se encargará de esperar el valor de su proceso hijo y añadir este a la matriz final*/
      else
      {
        int media;
        wait(&media);
        finmatrix[i/2][j/2] = (media >> 8);

      }
    }
  }

//Ahora imprimimos la matrix final por la consola para comprobar sus valores (opcional)
printf("Matriz reducida: \n");
for(int i = 0; i < matrixheight; i+=2)
  {
    for(int j = 0; j < matrixwidth; j+=2)
    {
      printf("%d\t",finmatrix[i/2][j/2]);
    }
    printf("\n");
  }
return 0;
}
