#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
  {
    int n = atoi (argv[1]);
    int m = atoi (argv[2]);
    int suma = n + m;

    printf("%d + %d = %d\n", n, m, suma);

    return suma;
  }
