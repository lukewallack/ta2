#include <stdio.h>
int main() {
  double x;
  x = 0;
  scanf("%lf", &x);
  x = x + 4.0;
  printf("%g\n", (double)(x));
  return 0;
}
