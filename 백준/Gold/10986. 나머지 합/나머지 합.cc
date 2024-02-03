#include <iostream>
#include <vector>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;
	vector<long> S(N, 0);
	vector<long> C(M, 0);
	long result = 0;

	cin >> S[0];
	for (int i = 1; i < N; i++)
	{
		int temp = 0;
		cin >> temp;
		S[i] = S[i - 1] + temp;
	}
	
	for (int i = 0; i < N; i++)
	{
		int remainder = S[i] % M;

		if (remainder == 0)
		{
			result++;
		}
		C[remainder]++;
	}

	for (int i = 0; i < M; i++)
	{
		if (C[i] > 1)
		{
			result = result + (C[i] * (C[i] - 1) / 2);
		}
	}

	cout << result << "\n";

	return 0;
}
