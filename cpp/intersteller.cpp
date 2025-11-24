#include <bits/stdc++.h>
using namespace std;

int MaxTime = 50;

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
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int relationCount;
    if(!(cin >> relationCount)) return 0;

    map<string,string> parentMap;
    map<string,int> orbitRadius;
    set<string> allNodes;

    for(int i = 0; i < relationCount; i++){
        string child, parent;
        int rad;
        cin >> child >> parent >> rad;
        parentMap[child] = parent;
        orbitRadius[child] = rad;
        allNodes.insert(child);
        allNodes.insert(parent);
    }

    string sourcePlanet, targetPlanet;
    cin >> sourcePlanet >> targetPlanet;
    allNodes.insert(sourcePlanet);
    allNodes.insert(targetPlanet);

    // find roots (nodes without parents)
    vector<string> rootNodes;
    for(auto &node : allNodes){
        if(parentMap.find(node) == parentMap.end())
            rootNodes.push_back(node);
    }

    // place root centers spaced apart to avoid overlap
    unordered_map<string, pair<int,int>> rootCenters;
    int rootIndex = 0;
    for(auto &root : rootNodes){
        rootCenters[root] = {rootIndex * 1000, 0};
        rootIndex++;
    }

    // precompute max orbit radius and orbit paths
    int maxOrbit = 0;
    for(auto &entry : orbitRadius) maxOrbit = max(maxOrbit, entry.second);

    vector<vector<pair<int,int>>> orbitPaths(maxOrbit + 1);
    for(int r = 0; r <= maxOrbit; r++) orbitPaths[r] = buildOrbit(r);

    // assign integer ids to nodes
    unordered_map<string,int> nodeId;
    vector<string> IdToName;
    int counter = 0;
    for(const string &node : allNodes){
        nodeId[node] = counter++;
        IdToName.push_back(node);
    }

    vector<int> parentId(counter, -1), radiusArr(counter, 0);
    for(auto &entry : parentMap){
        string child = entry.first;
        string parent = entry.second;
        parentId[nodeId[child]] = nodeId[parent];
        radiusArr[nodeId[child]] = orbitRadius[child];
    }

    // root coordinates
    vector<pair<int,int>> rootCoords(counter, {0,0});
    for(auto &root : rootNodes){
        rootCoords[nodeId[root]] = rootCenters[root];
    }

    // positions[node][t] = absolute coordinates at time t
    vector<vector<pair<int,int>>> positions(counter, vector<pair<int,int>>(MaxTime+1, {0,0}));

    // compute positions for each node for all times
    for(int i = 0; i < counter; i++){
        if(parentId[i] == -1){
            for(int t = 0; t <= MaxTime; t++){
                positions[i][t] = rootCoords[i];
            }
        } else {
            int pId = parentId[i];
            int rad = radiusArr[i];
            auto &orbitPath = orbitPaths[rad];
            int orbitLen = (int)orbitPath.size();
            for(int t = 0; t <= MaxTime; t++){
                pair<int,int> parentPos = positions[pId][t];
                pair<int,int> offset = orbitPath[t % orbitLen];
                positions[i][t] = {parentPos.first + offset.first, parentPos.second + offset.second};
            }
        }
    }

    int result = -1;
    int srcNode = nodeId[sourcePlanet];
    int tgtNode = nodeId[targetPlanet];
    
    // For each time, check if we can reach target from source
    for(int t = 0; t <= MaxTime; t++){
        int sx = positions[srcNode][t].first;
        int sy = positions[srcNode][t].second;
        int tx = positions[tgtNode][t].first;
        int ty = positions[tgtNode][t].second;
        
        // Distance we need to travel
        int dist = abs(sx - tx) + abs(sy - ty);
        
        // We have t time steps to travel this distance
        // We start at time 0 at source, so we have exactly t steps to reach target by time t
        if(dist == t){
            result = t;
            break;
        }
    }

    cout << result << "\n";
    return 0;
}
