#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int ring;
    int pos;
    int dist;
} Node;

int main(void) {
    int n;
    if (scanf("%d", &n) != 1) {
        return 0;
    }

    char **rings = (char **)malloc(n * sizeof(char *));
    int *lens = (int *)malloc(n * sizeof(int));
    int total = 0;

    for (int i = 0; i < n; ++i) {
        char buffer[2050];
        if (scanf("%s", buffer) != 1) {
            buffer[0] = '\0';
        }
        lens[i] = (int)strlen(buffer);
        rings[i] = (char *)malloc((lens[i] + 1) * sizeof(char));
        strcpy(rings[i], buffer);
        total += lens[i];
    }

    char **visited = (char **)malloc(n * sizeof(char *));
    for (int i = 0; i < n; ++i) {
        visited[i] = (char *)calloc(lens[i], sizeof(char));
    }

    Node *queue = (Node *)malloc(total * sizeof(Node));
    int front = 0, back = 0;
    int outer = n - 1;

    for (int idx = 0; idx < lens[outer]; ++idx) {
        if (rings[outer][idx] == '0') {
            visited[outer][idx] = 1;
            queue[back++] = (Node){outer, idx, 1};
        }
    }

    int answer = -1;
    while (front < back) {
        Node cur = queue[front++];
        int ring = cur.ring;
        int pos = cur.pos;
        int dist = cur.dist;

        if (ring == 0 && rings[0][pos] == '0') {
            answer = dist;
            break;
        }

        int ringLen = lens[ring];

        int left = (pos - 1 + ringLen) % ringLen;
        if (!visited[ring][left] && rings[ring][left] == '0') {
            visited[ring][left] = 1;
            queue[back++] = (Node){ring, left, dist + 1};
        }

        int right = (pos + 1) % ringLen;
        if (!visited[ring][right] && rings[ring][right] == '0') {
            visited[ring][right] = 1;
            queue[back++] = (Node){ring, right, dist + 1};
        }

        if (ring > 0) {
            int inner = pos / 2;
            if (!visited[ring - 1][inner] && rings[ring - 1][inner] == '0') {
                visited[ring - 1][inner] = 1;
                queue[back++] = (Node){ring - 1, inner, dist + 1};
            }
        }

        if (ring < n - 1) {
            int out0 = pos * 2;
            int out1 = out0 + 1;
            if (out0 < lens[ring + 1] && !visited[ring + 1][out0] && rings[ring + 1][out0] == '0') {
                visited[ring + 1][out0] = 1;
                queue[back++] = (Node){ring + 1, out0, dist + 1};
            }
            if (out1 < lens[ring + 1] && !visited[ring + 1][out1] && rings[ring + 1][out1] == '0') {
                visited[ring + 1][out1] = 1;
                queue[back++] = (Node){ring + 1, out1, dist + 1};
            }
        }
    }

    printf("%d", answer);

    for (int i = 0; i < n; ++i) {
        free(rings[i]);
        free(visited[i]);
    }
    free(rings);
    free(visited);
    free(lens);
    free(queue);

    return 0;
}