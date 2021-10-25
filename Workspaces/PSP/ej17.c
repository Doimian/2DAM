#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
int main(void)
{
  //Creamos la matriz de valores
  int matrix[4][4] = {{1,1,2,2},
                      {1,1,2,2},
                      {3,3,4,4},
                      {4,4,3,3}};

  int finmatrix[2][2];
  int matrixlength = sizeof(matrix) / sizeof(matrix[0]);
  int matrixwidth = sizeof(matrix) / sizeof(matrix[0]);
  pid_t pid;
  printf("Matriz original:\n");
  for(int i = 0; i < matrixlength; i+=2)
  {
    for(int j = 0; j < matrixwidth; j+=2)
    {
      pid = fork();

      if(pid == 0)
      {
        printf("%d\t%d\t%d\t%d\t\n",matrix[i][j],matrix[i][j+1],matrix[i+1][j],matrix[i+1][j+1]);
        int pmatrix[2][2] = {{matrix[i][j],matrix[i][j+1]},{matrix[i+1][j],matrix[i+1][j+1]}};
        int media = (pmatrix[0][0] + pmatrix[0][1] + pmatrix[1][0] + pmatrix[1][1]) / 4;
        exit(media);
      }
      else
      {
        int media;
        wait(&media);
        finmatrix[i/2][j/2] = (media >> 8);

      }
    }
  }

//Ahora imprimimos la matrix final por la consola para comprobar sus valores
printf("Matriz reducida: \n");
for(int i = 0; i < matrixlength; i+=2)
  {
    for(int j = 0; j < matrixwidth; j+=2)
    {
      printf("%d\t",finmatrix[i/2][j/2]);
    }
    printf("\n");
  }
return 0;
}
