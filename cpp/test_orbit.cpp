#include <bits/stdc++.h>
using namespace std;

vector<pair<int,int>> buildOrbit(int radius){
    if(radius == 0) return {{0,0}};
    int perimeter = 8 * radius;
    vector<pair<int,int>> path;
    set<pair<int,int>> visited;
    int cx = radius, cy = 0;
    path.push_back({cx, cy});
    visited.insert({cx, cy});
    vector<pair<int,int>> moves = {{0,1},{-1,0},{0,-1},{1,0}};
    for(int step = 1; step < perimeter; ++step){
        bool placed = false;
        for(auto &mv : moves){
            int nx = cx + mv.first;
            int ny = cy + mv.second;
            if(max(abs(nx), abs(ny)) == radius && visited.find({nx,ny}) == visited.end()){
                cx = nx; cy = ny;
                path.push_back({cx,cy});
                visited.insert({cx,cy});
                placed = true;
                break;
            }
        }
        if(!placed){
            for(auto &mv : moves){
                int nx = cx + mv.first;
                int ny = cy + mv.second;
                if(max(abs(nx), abs(ny)) == radius && visited.find({nx,ny}) == visited.end()){
                    cx = nx; cy = ny;
                    path.push_back({cx,cy});
                    visited.insert({cx,cy});
                    placed = true;
                    break;
                }
            }
        }
    }
    return path;
}

int main(){
    // Test orbit generation
    cout << "Orbit at radius 3:" << endl;
    auto orbit3 = buildOrbit(3);
    for(int i = 0; i < (int)orbit3.size(); i++){
        cout << "Time " << i << ": (" << orbit3[i].first << ", " << orbit3[i].second << ")" << endl;
    }
    
    cout << "\nOrbit at radius 5:" << endl;
    auto orbit5 = buildOrbit(5);
    for(int i = 0; i < (int)orbit5.size(); i++){
        cout << "Time " << i << ": (" << orbit5[i].first << ", " << orbit5[i].second << ")" << endl;
    }
    
    return 0;
}
