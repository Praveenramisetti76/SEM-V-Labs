#include <bits/stdc++.h>
using namespace std;

struct Card {
    int value; // 1..13
    int suit;  // 1..4
};

int parseValue(const string &s) {
    if (s == "A") return 1;
    if (s == "J") return 11;
    if (s == "Q") return 12;
    if (s == "K") return 13;
    return stoi(s);
}

// Sort / rearrange rule used both for initial decks and for claimed hand:
// 1) primary: non-decreasing card value (ascending).
// 2) if same value: lower priority suit comes first.
//    (we are given priority list from highest -> lowest; lower priority means later in that list)
void rearrange(vector<Card> &cards, const array<int,5> &priorityIndex) {
    sort(cards.begin(), cards.end(), [&](const Card &a, const Card &b){
        if (a.value != b.value) return a.value < b.value;
        // lower priority suit comes first -> larger priorityIndex value comes first
        return priorityIndex[a.suit] > priorityIndex[b.suit];
    });
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    if (!(cin >> N)) return 0;
    vector<Card> p1_in, p2_in;
    p1_in.reserve(N);
    p2_in.reserve(N);
    for (int i = 0; i < N; ++i) {
        string c1s, c2s;
        int s1, s2;
        cin >> c1s >> s1 >> c2s >> s2;
        Card a{ parseValue(c1s), s1 };
        Card b{ parseValue(c2s), s2 };
        p1_in.push_back(a);
        p2_in.push_back(b);
    }
    // read suit priorities: four integers (highest to lowest)
    array<int,5> priorityIndex; // index by suit (1..4) -> position (0 highest .. 3 lowest)
    for (int i = 0; i < 4; ++i) {
        int suit;
        cin >> suit;
        priorityIndex[suit] = i;
    }
    
    // Rearrange each player's deck before the game starts using rearrange rule
    rearrange(p1_in, priorityIndex);
    rearrange(p2_in, priorityIndex);
    
    deque<Card> p1, p2;
    for (auto &c : p1_in) p1.push_back(c);
    for (auto &c : p2_in) p2.push_back(c);
    
    vector<Card> hand; // central stack; back() is top of the hand
    int turn = 0; // 0 -> Vaishnavi (player1), 1 -> Suraj (player2). Vaishnavi plays first.
    
    // Simulate until result
    while (true) {
        // Check terminal states first
        if (p1.empty() && p2.empty()) {
            cout << "TIE\n";
            return 0;
        }
        if (turn == 0 && p1.empty()) { // Vaishnavi must draw but has no cards
            cout << "LOSER\n";
            return 0;
        }
        if (turn == 1 && p2.empty()) { // Suraj must draw but has no cards
            cout << "WINNER\n";
            return 0;
        }
        
        // Current player draws top card (front of deque)
        Card drawn;
        if (turn == 0) { drawn = p1.front(); p1.pop_front(); }
        else { drawn = p2.front(); p2.pop_front(); }
        
        if (hand.empty()) {
            // simply place on hand and pass turn
            hand.push_back(drawn);
            turn = 1 - turn;
            continue;
        }
        
        // Compare drawn card with top of hand
        Card top = hand.back();
        bool sameValue = (drawn.value == top.value);
        bool drawnHasHigherPriority = false;
        if (sameValue) {
            // higher priority means earlier in the provided list -> lower priorityIndex value
            if (priorityIndex[drawn.suit] < priorityIndex[top.suit]) drawnHasHigherPriority = true;
        }
        
        if (sameValue && drawnHasHigherPriority) {
            // current player claims the entire hand (including the newly drawn card)
            hand.push_back(drawn);
            // rearrange the entire hand
            rearrange(hand, priorityIndex);
            // add rearranged hand to bottom of winner's deck
            if (turn == 0) {
                for (auto &c : hand) p1.push_back(c);
            } else {
                for (auto &c : hand) p2.push_back(c);
            }
            hand.clear();
            // winner (same player) takes next turn -> turn remains the same
            continue;
        } else {
            // no claim -> put drawn card on top of hand and turn passes
            hand.push_back(drawn);
            turn = 1 - turn;
            continue;
        }
    }
    
    return 0;
}
