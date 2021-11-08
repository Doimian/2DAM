#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

//Si se quiere cambiar el grupo del proceso hijo hay que ejecutar el programa con permisos suficientes
int main(void)
{
  pid_t pid = fork();
  if(pid == 0)
  {
    printf("[HIJO] PID: %d   PPID: %d   GID: %d\n",getpid(),getppid(),getgid());
    sleep(5);
    printf("[HIJO] PID: %d   PPID: %d   GID: %d\n",getpid(),getppid(),getgid());
    sleep(5);
    gid_t gid = 1589;
    setgid(gid);
    printf("[HIJO] PID: %d   PPID: %d   GID: %d\n",getpid(),getppid(),getgid());
    exit(0);
  }
  else if(pid > 0)
  {
    printf("[PADRE] PID: %d   PPID: %d   GID: %d\n",pid,getppid(),getgid());
    sleep(5);
    //No añado wait() porque sobreentiendo que la actividad quiere que dejemos el proceso huérfano, si hubiese que añadirlo descomentar la siguiente linea
    //wait(NULL);
    return 0;
  }
}
