#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_THREADS 8 // cambiamos
#define VECTOR_SIZE 100000000

pthread_t tid[MAX_THREADS];
pthread_mutex_t mutex;

int *array;
int length = VECTOR_SIZE;

// Definición de contadores privados para cada hilo
int private_count[MAX_THREADS];
int count = 0;
int double_count = 0;
int max_threads = MAX_THREADS;

void *count3s_thread(void *arg){
	int i;
	int length_per_thread = length / max_threads; // cada hilo procese una parte del vector,
	long id = (long)arg;
	int start = id * length_per_thread;


	for(i = start; i < start + length_per_thread; i++){
		if (array[i] == 3){
			private_count[id]++; // cambia
		}
	}
	// cambia... sección crítica
	pthread_mutex_lock(&mutex);
	count = count + private_count[id];
	pthread_mutex_unlock(&mutex);
	
	return NULL;
}

void initialize_vector(){
	int i = 0;
	array = (int*) malloc(sizeof(int) * VECTOR_SIZE);
	if(array == NULL){
		printf("Allocation memory failed\n");
		exit(-1);
	}
	for(;i < VECTOR_SIZE; i++){
		array[i] = rand() % 20;
		if (array[i] == 3)
			double_count++;
	}
}

int main(int argc, char* argv[]){
	long i = 0;
	int err;
	clock_t t1, t2;

	if (argc == 2){
		max_threads = atoi(argv[1]);
		if (max_threads > MAX_THREADS){
			max_threads = MAX_THREADS;
		}else{}
	}else{
		max_threads = MAX_THREADS;
	}
	printf("Running 3s-00 Using %d threads\n", max_threads);
	
	srand(time(NULL));
	printf("*** 3s-01 ***\n");
	printf("Initializing vector.... ");
	fflush(stdout);
	initialize_vector();
	printf("Vector initialized! \n");
	fflush(stdout);
	t1 = clock();
	pthread_mutex_init(&mutex, NULL);
	while(i < max_threads){
		err = pthread_create(&tid[i], NULL, &count3s_thread, (void*)i);
		if (err != 0)
			printf("[3s-01] Can't create a thread [%ld]\n",i);
		else
			printf("[3s-01] Thread created [%ld]\n", i);
		i++;
	}
	i = 0;
	for(; i < max_threads; i++){
		void *status;
		int rc;
		rc = pthread_join(tid[i],&status);
		if(rc){
			printf("ERROR; return code from pthread() is %d \n", rc);
			exit(-1);
		}else{
			printf("Thread [%ld] exited with status [%ld] \n", i, (long)status);
		}
	}
	t2 = clock();
	printf("[3s-01] Count by threads %d\n",count);
	printf("[3s-01] Double check %d!\n",double_count);
	pthread_mutex_destroy(&mutex);
	printf("[3s-01] Elapsed time %f\n",(((float)t2 - (float)t1) /1000000.0F) * 1000);
	printf("Finishing 3s-00");
	return 0;
}
