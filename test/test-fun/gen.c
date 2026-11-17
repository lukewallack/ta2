#include <stdio.h>
int main() {
  double x, i;
  x = 0;
  i = 0;
  scanf("%lf", &x);
  i = 0.0;
  printf("%g\n", (double)(i));
  while (x != 0.0) {
    i = i + x;
    printf("%g\n", (double)(i));
    x = x - 1.0;
    printf("%g\n", (double)(x));
  }
  return 0;
}
