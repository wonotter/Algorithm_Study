#include <iostream>
using namespace std;

int main(void)
{
	int input = 0;
	int sum = 0;
	char num;

	cin >> input;
	cin.get();

	for (int i = 0; i < input; i++)
	{
		cin.get(num);
		int temp = num - '0';
		sum += temp;
	}

	cout << sum << endl;

	return 0;
}
