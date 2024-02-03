#include <iostream>
#include <vector>
using namespace std;

int main(void)
{
	int N;
	double sum = 0;
	vector<int> A;

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		int data;
		cin >> data;
		A.push_back(data);
	}

	int max = A[0];
	for (int j = 0; j < N; j++)
	{
		if (max < A[j])
			max = A[j];
		sum += A[j];
	}

	cout << sum * 100 / max / N;

	return 0;
}