#include <stdio.h>
int main() {
  double x;
  x = 0;
  x = 5.0;
  printf("%g\n", (double)(x));
  while (x != 0.0) {
    x = x - 1.0;
    printf("%g\n", (double)(x));
  }
  return 0;
}
