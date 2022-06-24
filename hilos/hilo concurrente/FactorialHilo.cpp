#include <pthread.h>
#include <stdio.h>

void *factorial(void *factorial_ptr)
{
    int n;
    int *fact_ptr = (int *)factorial_ptr;
    n = 10;
    for (int i = 3; i <= n; ++i)
    {
        /* code */
        for (int j = 1; j <= i; j++)
            *fact_ptr = *fact_ptr * j;

        printf("Factorial de %d, -> %d\n", i, *fact_ptr);
        *fact_ptr = 1;
    }

    return NULL;
}

int main()
{
    long int j = 1;
    int i = 1;
    while (i < 8)
    {
        pthread_t fact_thread;
        pthread_create(&fact_thread, NULL, factorial, &j);
        printf("[3s-01] Can't create a thread [%d]\n", i);
        i++;
    }
    // fact(factorial);
}

