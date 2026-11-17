#include <stdio.h>
int main() {
  double x, y;
  x = 0;
  y = 0;
  x = 1.5 + 1.5;
  printf("%g\n", (double)(x));
  y = 1.5 + 1.0;
  printf("%g\n", (double)(y));
  return 0;
}
