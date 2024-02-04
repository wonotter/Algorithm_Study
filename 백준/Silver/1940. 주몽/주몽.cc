#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;
	vector<int> A(N, 0);

	for (int i = 0; i < N; i++)
	{
		cin >> A[i];
	}
	sort(A.begin(), A.end());

	int i = 0;
	int j = N - 1;
	int cnt = 0;

	while (i < j)
	{
		if (A[i] + A[j] == M)
		{
			cnt++;
			i++;
			j--;
		}

		else if (A[i] + A[j] > M)
		{
			j--;
		}

		else if (A[i] + A[j] < M)
		{
			i++;
		}
	}

	cout << cnt << "\n";

	return 0;
}
