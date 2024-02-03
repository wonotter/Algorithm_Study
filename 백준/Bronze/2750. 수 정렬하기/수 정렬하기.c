#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int temp = 0;
	int N = 0;
	scanf("%d", &N);
	int* arr = malloc(sizeof(int) * N);

	for (int a = 0; a < N; a++)
	{
		scanf("%d", &arr[a]);
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N - 1; j++)
		{
			if (arr[j + 1] < arr[j])
			{
				temp = arr[j + 1];
				arr[j + 1] = arr[j];
				arr[j] = temp;
			}
		}
	}

	for (int z = 0; z < N; z++)
	{
		printf("%d ", arr[z]);
	}
	free(arr);
	return 0;
}