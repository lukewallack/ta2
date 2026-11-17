#include <stdio.h>
int main() {
  double x;
  x = 0;
  x = 5.0;
  printf("%g\n", (double)(x));
  if (x > 4.0) {
    printf("%g\n", (double)(1.0));
  } else {
    printf("%g\n", (double)(2.0));
  }
  return 0;
}
