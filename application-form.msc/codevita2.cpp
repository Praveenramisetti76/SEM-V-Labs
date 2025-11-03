#include <bits/stdc++.h>
using namespace std;

// Hash function for vector<string> so we can use unordered_set
struct VecHash {
    size_t operator()(const vector<string>& v) const {
        size_t h = 0;
        for (auto &s : v)
            h ^= hash<string>()(s) + 0x9e3779b9 + (h << 6) + (h >> 2);
        return h;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    string temp;
    cin >> temp; // "shuffled"
    cin.ignore();

    vector<string> shuffled(N), original(N);
    for (int i = 0; i < N; i++) getline(cin, shuffled[i]);

    cin >> temp; // "original"
    cin.ignore();
    for (int i = 0; i < N; i++) getline(cin, original[i]);

    queue<pair<vector<string>, int>> q;
    unordered_set<vector<string>, VecHash> visited;

    q.push({shuffled, 0});
    visited.insert(shuffled);

    while (!q.empty()) {
        auto [curr, cost] = q.front(); 
        q.pop();

        if (curr == original) {
            cout << cost << "\n";
            return 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                vector<string> block(curr.begin() + i, curr.begin() + j + 1);
                vector<string> remaining;
                for (int k = 0; k < N; k++) {
                    if (k < i || k > j)
                        remaining.push_back(curr[k]);
                }

                for (int pos = 0; pos <= (int)remaining.size(); pos++) {
                    vector<string> next = remaining;
                    next.insert(next.begin() + pos, block.begin(), block.end());
                    if (!visited.count(next)) {
                        visited.insert(next);
                        q.push({next, cost + 1});
                    }
                }
            }
        }
    }

    return 0;
}
