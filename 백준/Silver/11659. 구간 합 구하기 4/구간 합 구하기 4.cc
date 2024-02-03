#include <iostream>
using namespace std;

int main(void)
{
	int N, M;
	cin >> N >> M;

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int S[100001] = { 0, };

	for (int i = 1; i <= N; i++)
	{
		int data;
		cin >> data;
		S[i] = S[i - 1] + data;
	}

	for (int i = 0; i < M; i++)
	{
		int start, end;
		cin >> start >> end;
		cout << S[end] - S[start - 1] << "\n";
	}

	return 0;
}
