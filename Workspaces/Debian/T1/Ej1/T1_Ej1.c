/*
    PSP
    Tema 1
    Ejercicio 1
*/
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>

int main(void)
{
    if(execl("/bin/ls", "ls", "-a", "-l", "usr/bin", NULL) ==-1)
        printf("Error\n");
    else
        printf("Codigo muerto\n");
}