#include <iostream>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin.tie(NULL);

	int start_idx = 1;
	int end_idx = 1;
	int sum = 1;
	int count = 1;
	int N;
	cin >> N;

	while (end_idx != N)
	{
		if (sum == N)
		{
			count++;
			end_idx++;
			sum += end_idx;
		}

		else if (sum < N)
		{
			end_idx++;
			sum += end_idx;
		}

		else if (sum > N)
		{
			sum -= start_idx;
			start_idx++;
		}
	}

	cout << count << "\n";

	return 0;
}
