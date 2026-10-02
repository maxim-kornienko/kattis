#include <stdio.h>

void trim(char str[], int size) {
    for (size_t i = 0; i < size; i++) {
        if (str[i] == '\n') {
            str[i] = '\0';
            return;
        }
    }
}

// 1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
// https://open.kattis.com/problems/skeytasaman
int main() {
    char s[102];
    char t[102];
    if (fgets(s, sizeof(s), stdin) == NULL) {
        return -1;
    }
    if (fgets(t, sizeof(t), stdin) == NULL) {
        return -1;
    }

    trim(s, sizeof(s));
    trim(t, sizeof(t));

    printf("%s", s);
    printf("%s", t);
    putchar('\n');

    return 0;
}